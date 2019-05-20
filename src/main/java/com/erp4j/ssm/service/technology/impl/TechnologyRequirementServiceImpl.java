package com.erp4j.ssm.service.technology.impl;

import com.erp4j.ssm.mapper.technology.TechnologyRequirementMapper;
import com.erp4j.ssm.pojo.technology.TechnologyRequirement;
import com.erp4j.ssm.pojo.technology.TechnologyRequirementExample;
import com.erp4j.ssm.service.technology.TechnologyRequirementService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 11:24
 * @Description:
 */

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;


    @Override
    public List<TechnologyRequirement> queryTechnologyRequirement(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.queryTechnologyRequirement();
        return technologyRequirements;
    }

    @Override
    public int queryTotal() {
        int total = technologyRequirementMapper.queryTotal();
        return total;
    }

    @Override
    public boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int result = technologyRequirementMapper.insertSelective(technologyRequirement);
        return result == 1;
    }

    @Override
    public boolean updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int result = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return result == 1;
    }

    @Override
    public boolean deleteMultiTechnologyRequirement(List<String> ids) {
        TechnologyRequirementExample technologyRequirementExample = new TechnologyRequirementExample();
        TechnologyRequirementExample.Criteria criteria = technologyRequirementExample.createCriteria();
        criteria.andTechnologyRequirementIdIn(ids);
        int result = technologyRequirementMapper.deleteByExample(technologyRequirementExample);
        return result == ids.size();
    }

    @Override
    public List<TechnologyRequirement> queryTechnologyRequirementById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.queryTechnologyRequirementById(searchValue);
        return technologyRequirements;
    }

    @Override
    public int queryTotalById(String searchValue) {
        int total = technologyRequirementMapper.queryTotalById(searchValue);
        return total;
    }

    @Override
    public List<TechnologyRequirement> queryTechnologyRequirementByTechnologyName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.queryTechnologyRequirementByTechnologyName(searchValue);
        return technologyRequirements;
    }

    @Override
    public int queryTotalByTechnologyName(String searchValue) {
        int total = technologyRequirementMapper.queryTotalByTechnologyName(searchValue);
        return total;
    }
}
