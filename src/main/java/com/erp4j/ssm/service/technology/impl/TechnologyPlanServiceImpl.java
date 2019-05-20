package com.erp4j.ssm.service.technology.impl;

import com.erp4j.ssm.mapper.technology.TechnologyPlanMapper;
import com.erp4j.ssm.pojo.technology.TechnologyPlan;
import com.erp4j.ssm.pojo.technology.TechnologyPlanExample;
import com.erp4j.ssm.service.technology.TechnologyPlanService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 14:01
 * @Description:
 */

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public List<TechnologyPlan> queryTechnologyPlan(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.queryTechnologyPlan();
        return technologyPlans;
    }

    @Override
    public int queryTotal() {
        int total = technologyPlanMapper.queryTotal();
        return total;
    }

    @Override
    public boolean insertTechnologyPlan(TechnologyPlan technologyPlan) {
        int result = technologyPlanMapper.insertSelective(technologyPlan);
        return result == 1;
    }

    @Override
    public boolean updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int result = technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
        return result == 1;
    }

    @Override
    public boolean deleteMultiTechnologyPlan(List<String> ids) {
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        TechnologyPlanExample.Criteria criteria = technologyPlanExample.createCriteria();
        criteria.andTechnologyPlanIdIn(ids);
        int result = technologyPlanMapper.deleteByExample(technologyPlanExample);
        return result == ids.size();
    }

    @Override
    public List<TechnologyPlan> queryTechnologyPlanById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.queryTechnologyPlanById(searchValue);
        return technologyPlans;
    }

    @Override
    public int queryTotalById(String searchValue) {
        int total = technologyPlanMapper.queryTotalById(searchValue);
        return total;
    }

    @Override
    public List<TechnologyPlan> queryTechnologyPlanByTechnologyName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.queryTechnologyPlanByTechnologyName(searchValue);
        return technologyPlans;
    }

    @Override
    public int queryTotalByTechnologyName(String searchValue) {
        int total = technologyPlanMapper.queryTotalByTechnologyName(searchValue);
        return total;
    }

    @Override
    public TechnologyPlan queryTechnologyPlanById(String technologyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.querySingleById(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public List<TechnologyPlan> queryTechnologyPlan() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.queryTechnologyPlan();
        return technologyPlans;
    }
}
