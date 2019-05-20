package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.EmployeeMapper;
import com.erp4j.ssm.pojo.Employee;
import com.erp4j.ssm.pojo.EmployeeExample;
import com.erp4j.ssm.service.quality.monitor.EmployeeService;
import com.erp4j.ssm.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public ResponseVo selectEmployeeAll(int page, int rows) {
        ResponseVo<Employee> responseVo = new ResponseVo<>();

        PageHelper.startPage(page,rows);
        ArrayList<Employee> employees = employeeMapper.selectEmployeeAll(null,null,null);
        responseVo.setRows(employees);

        long count = employeeMapper.countByExample(new EmployeeExample());
        responseVo.setTotal((int)count);

        return responseVo;
    }

    @Override
    public ResponseStatus insertEmployee(Employee employee) {
        if(employeeMapper.insert(employee) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("插入失败","400");
        }
    }

    @Override
    public ResponseStatus updateEmployee(Employee employee) {
        if(employeeMapper.updateByPrimaryKeySelective(employee) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        } else {
            return ResponseUtil.getResponseStatus("修改失败","400");
        }

    }

    @Override
    public ResponseStatus deleteBatchEmployee(String[] ids) {
        /*EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(ids);

        if(employeeMapper.deleteByExample(employeeExample) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else{
            return ResponseUtil.getResponseStatus("删除失败","400");
        }*/
        for (String id : ids) {
            if(employeeMapper.deleteByPrimaryKey(id) == 0){
                return ResponseUtil.getResponseStatus("删除失败","400");
            }
        }
        return ResponseUtil.getResponseStatus("OK","200");
    }

    @Override
    public ResponseVo searchEmployeeByEmployeeId(QueryParameters queryParameters) {
        ResponseVo<Employee> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<Employee> employees = employeeMapper.selectEmployeeAll("%" + queryParameters.getSearchValue() + "%",null,null);
        responseVo.setRows(employees);

        int count = employeeMapper.selectEmployeeBy("%" + queryParameters.getSearchValue() + "%",null,null);
        responseVo.setTotal(count);

        return responseVo;
    }

    @Override
    public ResponseVo searchEmployeeByEmployeeName(QueryParameters queryParameters) {
        ResponseVo<Employee> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<Employee> employees = employeeMapper.selectEmployeeAll(null,"%" + queryParameters.getSearchValue() + "%",null);
        responseVo.setRows(employees);

        int count = employeeMapper.selectEmployeeBy(null,"%" + queryParameters.getSearchValue() + "%",null);
        responseVo.setTotal(count);

        return responseVo;
    }

    @Override
    public ResponseVo searchEmployeeByDepartmentName(QueryParameters queryParameters) {
        ResponseVo<Employee> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<Employee> employees = employeeMapper.selectEmployeeAll(null,null,"%" + queryParameters.getSearchValue() + "%");
        responseVo.setRows(employees);

        int count = employeeMapper.selectEmployeeBy(null,null,"%" + queryParameters.getSearchValue() + "%");
        responseVo.setTotal(count);

        return responseVo;
    }
}
