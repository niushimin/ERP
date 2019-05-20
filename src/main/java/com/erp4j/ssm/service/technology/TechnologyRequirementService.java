package com.erp4j.ssm.service.technology;

import com.erp4j.ssm.pojo.technology.TechnologyRequirement;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 11:24
 * @Description:
 */
public interface TechnologyRequirementService {

    List<TechnologyRequirement> queryTechnologyRequirement(int page, int rows);

    int queryTotal();

    boolean insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    boolean deleteMultiTechnologyRequirement(List<String> ids);

    List<TechnologyRequirement> queryTechnologyRequirementById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<TechnologyRequirement> queryTechnologyRequirementByTechnologyName(String searchValue, int page, int rows);

    int queryTotalByTechnologyName(String searchValue);

}
