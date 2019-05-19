package com.erp4j.ssm.mapper.work;

import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkExample;
import java.util.List;

import com.erp4j.ssm.pojo.work.WorkVo;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> queryWork();

    int insertWork(WorkVo workVo);

    int updateWork(WorkVo workVo);

    List<Work> queryCOrderById(String searchValue);

    List<Work> queryWorkByProduct(String searchValue);

    int queryTotalByProduct(String searchValue);

    List<Work> queryWorkByDevice(String searchValue);

    int queryTotalByDevice(String searchValue);

    List<Work> queryWorkByProcess(String searchValue);

    int queryTotalByProcess(String searchValue);
}