package com.erp4j.ssm.mapper.material;

import com.erp4j.ssm.pojo.MaterialReceive;
import com.erp4j.ssm.pojo.MaterialReceiveExample;
import java.util.List;

import com.erp4j.ssm.pojo.material.MaterialReceiveVo;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveMapper {

    List<MaterialReceiveVo> find();

    int updateNote(MaterialReceiveVo materialReceiveVo);

    List<MaterialReceiveVo> searchMaterialReceiveByReceiveId(String receiveId);

    List<MaterialReceiveVo> searchMaterialReceiveByMaterialId(String materialId);













    //逆向工程生成
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);



}