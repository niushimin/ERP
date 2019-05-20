package com.erp4j.ssm.service.department.impl;

import com.erp4j.ssm.mapper.department.DepartmentMapper;
import com.erp4j.ssm.pojo.department.Department;
import com.erp4j.ssm.pojo.department.DepartmentExample;
import com.erp4j.ssm.service.department.DepartmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 23:48
 * @Description:
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryDepartment(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        return departments;
    }

    @Override
    public int queryTotal() {
        int total = (int) departmentMapper.countByExample(new DepartmentExample());
        return total;
    }

    @Override
    public boolean insertDepartment(Department department) {
        int result = departmentMapper.insertSelective(department);
        return result == 1;
    }

    @Override
    public boolean updateDepartment(Department department) {
        int result = departmentMapper.updateByPrimaryKeySelective(department);
        return result == 1;
    }

    @Override
    public boolean deleteMultiDepartment(List<String> ids) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdIn(ids);
        int result = departmentMapper.deleteByExample(departmentExample);
        return result == ids.size();
    }

    @Override
    public List<Department> queryDepartmentById(String searchValue, int page, int rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdLike("%" + searchValue + "%");
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public int queryTotalById(String searchValue) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdLike("%" + searchValue + "%");
        int total = (int) departmentMapper.countByExample(departmentExample);
        return total;
    }

    @Override
    public List<Department> queryDepartmentByName(String searchValue, int page, int rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentNameLike("%" + searchValue + "%");
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    @Override
    public int queryTotalByName(String searchValue) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentNameLike("%" + searchValue + "%");
        int total = (int) departmentMapper.countByExample(departmentExample);
        return total;
    }

    @Override
    public List<Department> searchDepartemtAll() {
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());

        return departments;
    }
}
