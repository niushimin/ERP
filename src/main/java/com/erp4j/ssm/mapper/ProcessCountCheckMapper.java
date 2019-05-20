package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.ProcessCountCheck;
import com.erp4j.ssm.pojo.ProcessCountCheckExample;

import java.util.ArrayList;
import java.util.List;

import com.erp4j.ssm.pojo.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

public interface ProcessCountCheckMapper {
    long countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    ArrayList<ProcessMeasureCheck> selectpMeasureCheckAll();

    ArrayList<ProcessCountCheck> selectPCountCheckAll();
}