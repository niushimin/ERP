package com.erp4j.ssm.service.customer.impl;

import com.erp4j.ssm.mapper.custom.CustomMapper;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.custom.CustomExample;
import com.erp4j.ssm.service.customer.CustomService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 23:26
 * @Description:
 */
@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> queryCustom(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Custom> customs = customMapper.selectByExample(new CustomExample());
        return customs;
    }

    @Override
    public int queryTotal() {
            int total = (int) customMapper.countByExample(new CustomExample());
        return total;
    }

    @Override
    public boolean insertCustom(Custom custom) {
        int result = customMapper.insertSelective(custom);
        return result >= 1;
    }
}
