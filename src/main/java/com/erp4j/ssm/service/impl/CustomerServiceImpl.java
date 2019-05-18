package com.erp4j.ssm.service.impl;

import com.erp4j.ssm.mapper.CustomMapper;
import com.erp4j.ssm.pojo.Custom;
import com.erp4j.ssm.pojo.CustomExample;
import com.erp4j.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 23:26
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public int findTotal() {
        int total = (int) customMapper.countByExample(new CustomExample());
        return total;
    }

    @Override
    public List<Custom> findRows() {
        List<Custom> customs = customMapper.selectByExample(new CustomExample());
        return customs;
    }
}
