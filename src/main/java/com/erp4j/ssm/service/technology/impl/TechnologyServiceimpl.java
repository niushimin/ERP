package com.erp4j.ssm.service.technology.impl;

import com.erp4j.ssm.mapper.technology.TechnologyMapper;
import com.erp4j.ssm.pojo.technology.Technology;
import com.erp4j.ssm.pojo.technology.TechnologyExample;
import com.erp4j.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 18:07
 * @Description:
 */

@Service
public class TechnologyServiceimpl implements TechnologyService {

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
}
