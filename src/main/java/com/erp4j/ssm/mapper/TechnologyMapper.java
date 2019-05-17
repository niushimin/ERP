package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.Technology;
import com.erp4j.ssm.pojo.TechnologyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}