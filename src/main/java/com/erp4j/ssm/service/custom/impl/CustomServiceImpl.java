package com.erp4j.ssm.service.custom.impl;

import com.erp4j.ssm.mapper.custom.CustomMapper;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.custom.CustomExample;
import com.erp4j.ssm.service.custom.CustomService;
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
        return result == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdIn(ids);
        int result = customMapper.deleteByExample(customExample);
        return result == ids.size();
    }

    @Override
    public boolean updateCustom(Custom custom) {
        int result = customMapper.updateByPrimaryKeySelective(custom);
        return result == 1;
    }

    @Override
    public List<Custom> queryCustom() {
        List<Custom> customs = customMapper.selectByExample(new CustomExample());
        return customs;
    }

    @Override
    public Custom queryCustomById(String customId) {
        Custom custom = customMapper.selectByPrimaryKey(customId);
        return custom;
    }

    @Override
    public List<Custom> queryCustomById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdLike("%" + searchValue + "%");
        List<Custom> list = customMapper.selectByExample(customExample);
        return list;
    }

    @Override
    public int queryTotalById(String searchValue) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdLike("%" + searchValue + "%");
        int total = (int) customMapper.countByExample(customExample);
        return total;
    }

    @Override
    public List<Custom> queryCustomByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomNameLike("%" + searchValue + "%");
        List<Custom> list = customMapper.selectByExample(customExample);
        return list;
    }

    @Override
    public int queryTotalByName(String searchValue) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomNameLike("%" + searchValue + "%");
        int total = (int) customMapper.countByExample(customExample);
        return total;
    }
}
