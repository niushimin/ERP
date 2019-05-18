package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.DepartmentMapper;
import com.erp4j.ssm.mapper.EmployeeMapper;
import com.erp4j.ssm.mapper.ProductMapper;
import com.erp4j.ssm.mapper.UnqualifyApplyMapper;
import com.erp4j.ssm.pojo.*;
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;
import com.erp4j.ssm.mapper.quality.monitor.UnqualifyMapper;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class UnqulifyFindServiceImpl implements UnqulifyFindService {
    @Autowired
    UnqualifyMapper unqualifyMapper;
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * 返回一个全列表
     * @param page 页数
     * @param rows 每一页行数
     * @return
     */
    @Override
    public ResponseVo getResponseVo(int page, int rows) {
        ResponseVo<UnqualifyApplyPojo> unqualifyApplyPojoResponseVo = new ResponseVo<>();
        /*分页*/
        PageHelper.startPage(page, rows);
        List<UnqualifyApplyPojo> unqualifyApplyPojos = unqualifyMapper.queryUnqulifyApplyAll(page,rows);
        unqualifyApplyPojoResponseVo.setRows(unqualifyApplyPojos);
        /*查询总数*/
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        long unqualifyCount = unqualifyApplyMapper.countByExample(unqualifyApplyExample);
        unqualifyApplyPojoResponseVo.setTotal((int)unqualifyCount);
        return unqualifyApplyPojoResponseVo;
    }

    @Override
    public Product selectProductById(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public EmployeeForm selectEmployeeById(String empId) {
        Employee employee = employeeMapper.selectByPrimaryKey(empId);
        Department department = departmentMapper.selectByPrimaryKey(employee.getEmpId());
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setDegree("博士");
        employeeForm.setDepartment(department);

        try {
            BeanUtils.copyProperties(employeeForm,employee);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return employeeForm;
    }

    @Override
    public List<Product> selectProductAll() {
        List<Product> products = productMapper.selectByExample(new ProductExample());
        return products;
    }

    @Override
    public List<Employee> selectEmployAll() {
        List<Employee> employees = employeeMapper.selectByExample(new EmployeeExample());
        return employees;
    }

    @Override
    public void deleteUnqulifyById(String[] ids) {
        for (String id : ids) {
            unqualifyApplyMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void insertUnqulify(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
    }

    @Override
    public ResponseStatus getResponseStatus() {
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setMsg("OK");
        responseStatus.setStatus("200");
        return responseStatus;
    }

    @Override
    public void unqulifyUpdateAll(UnqualifyApply unqualifyApply) {
        unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
    }
}
