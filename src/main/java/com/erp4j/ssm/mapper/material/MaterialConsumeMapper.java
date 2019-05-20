package com.erp4j.ssm.mapper.material;

import com.erp4j.ssm.pojo.MaterialConsume;
import com.erp4j.ssm.pojo.MaterialConsumeExample;
import java.util.List;

import com.erp4j.ssm.pojo.material.MaterialConsumeVo;
import org.apache.ibatis.annotations.Param;

public interface MaterialConsumeMapper {

    List<MaterialConsumeVo> find(MaterialConsumeVo materialConsumeVo);






























    //逆向工程生成
    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);


}