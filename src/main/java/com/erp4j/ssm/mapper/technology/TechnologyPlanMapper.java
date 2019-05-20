package com.erp4j.ssm.mapper.technology;

import com.erp4j.ssm.pojo.technology.TechnologyPlan;
import com.erp4j.ssm.pojo.technology.TechnologyPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> queryTechnologyPlan();

    int queryTotal();

    List<TechnologyPlan> queryTechnologyPlanByTechnologyName(String searchValue);

    int queryTotalByTechnologyName(String searchValue);

    List<TechnologyPlan> queryTechnologyPlanById(String searchValue);

    int queryTotalById(String searchValue);

    TechnologyPlan querySingleById(String technologyPlanId);
}