package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.EmployeeMapper;
import com.erp4j.ssm.pojo.Employee;
import com.erp4j.ssm.service.quality.monitor.EmployeeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public ResponseVo selectEmployeeAll(int page, int rows) {
        ResponseVo<Employee> employeeResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,rows);

        return null;
    }
}
