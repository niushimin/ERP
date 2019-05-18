package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.DeviceTypeExample;
import java.util.List;

import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import org.apache.ibatis.annotations.Param;

public interface DeviceTypeMapper {

    List<DeviceTypeVo> find(DeviceTypeVo deviceTypeVo);





    //逆向工程生成
    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);


}