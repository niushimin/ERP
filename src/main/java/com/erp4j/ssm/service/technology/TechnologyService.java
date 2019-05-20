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

    List<Technology> queryTechnology(int page, int rows);

    int queryTotal();

    boolean insertTechnology(Technology technology);

    boolean updateTechnology(Technology technology);

    boolean deleteMultiTechnology(List<String> ids);

    List<Technology> queryTechnologyById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Technology> queryTechnologyByName(String searchValue, int page, int rows);

    int queryTotalByName(String searchValue);

}
