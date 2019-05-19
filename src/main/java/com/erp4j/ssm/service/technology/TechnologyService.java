package com.erp4j.ssm.service.technology;

import com.erp4j.ssm.pojo.technology.Technology;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 18:06
 * @Description:
 */
public interface TechnologyService {

    Technology queryTechnologyById(String technologyId);

    List<Technology> queryTechnology();
}
