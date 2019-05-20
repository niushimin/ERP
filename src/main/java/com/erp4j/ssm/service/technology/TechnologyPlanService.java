package com.erp4j.ssm.service.technology;

import com.erp4j.ssm.pojo.technology.TechnologyPlan;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 14:01
 * @Description:
 */
public interface TechnologyPlanService {

    List<TechnologyPlan> queryTechnologyPlan(int page, int rows);

    int queryTotal();

    boolean insertTechnologyPlan(TechnologyPlan technologyPlan);

    boolean updateTechnologyPlan(TechnologyPlan technologyPlan);

    boolean deleteMultiTechnologyPlan(List<String> ids);

    List<TechnologyPlan> queryTechnologyPlanById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<TechnologyPlan> queryTechnologyPlanByTechnologyName(String searchValue, int page, int rows);

    int queryTotalByTechnologyName(String searchValue);

    TechnologyPlan queryTechnologyPlanById(String technologyPlanId);

    List<TechnologyPlan> queryTechnologyPlan();
}
