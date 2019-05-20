package com.erp4j.ssm.mapper.technology;

import com.erp4j.ssm.pojo.technology.TechnologyRequirement;
import com.erp4j.ssm.pojo.technology.TechnologyRequirementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> queryTechnologyRequirement();

    int queryTotal();

    List<TechnologyRequirement> queryTechnologyRequirementByTechnologyName(String searchValue);

    int queryTotalByTechnologyName(String searchValue);

    List<TechnologyRequirement> queryTechnologyRequirementById(String searchValue);

    int queryTotalById(String searchValue);
}