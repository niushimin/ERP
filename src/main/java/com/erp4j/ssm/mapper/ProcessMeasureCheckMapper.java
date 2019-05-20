package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.ProcessMeasureCheck;
import com.erp4j.ssm.pojo.ProcessMeasureCheckExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessMeasureCheckMapper {
    long countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    ArrayList<ProcessMeasureCheck> selectpMeasureCheckAll();
}