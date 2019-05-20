package com.erp4j.ssm.service.technology.impl;

import com.erp4j.ssm.mapper.technology.TechnologyMapper;
import com.erp4j.ssm.pojo.technology.Technology;
import com.erp4j.ssm.pojo.technology.TechnologyExample;
import com.erp4j.ssm.service.technology.TechnologyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 18:07
 * @Description:
 */

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;


    @Override
    public Technology queryTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public List<Technology> queryTechnology() {
        List<Technology> technologies = technologyMapper.selectByExample(new TechnologyExample());
        return technologies;
    }

    @Override
    public List<Technology> queryTechnology(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.selectByExample(new TechnologyExample());
        return technologies;
    }

    @Override
    public int queryTotal() {
        int total = (int) technologyMapper.countByExample(new TechnologyExample());
        return total;
    }

    @Override
    public boolean insertTechnology(Technology technology) {
        int result = technologyMapper.insertSelective(technology);
        return result == 1;
    }

    @Override
    public boolean updateTechnology(Technology technology) {
        int result = technologyMapper.updateByPrimaryKeySelective(technology);
        return result == 1;
    }

    @Override
    public boolean deleteMultiTechnology(List<String> ids) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdIn(ids);
        int result = technologyMapper.deleteByExample(technologyExample);
        return result == ids.size();
    }

    @Override
    public List<Technology> queryTechnologyById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdLike("%" + searchValue + "%");
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public int queryTotalById(String searchValue) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyIdLike("%" + searchValue + "%");
        int total = (int) technologyMapper.countByExample(technologyExample);
        return total;
    }

    @Override
    public List<Technology> queryTechnologyByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike("%" + searchValue + "%");
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public int queryTotalByName(String searchValue) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike("%" + searchValue + "%");
        int total = (int) technologyMapper.countByExample(technologyExample);
        return total;
    }

}
