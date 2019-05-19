package com.erp4j.ssm.mapper.device;

import com.erp4j.ssm.pojo.DeviceCheck;
import com.erp4j.ssm.pojo.DeviceCheckExample;
import java.util.List;

import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {


    List<DeviceCheckVo> find(DeviceCheckVo deviceCheckVo);

    int updateNote(DeviceCheckVo deviceCheckVo);












    //逆向工程生成
    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);


    List<DeviceCheckVo> searchDeviceCheckByDeviceCheckId(String deviceCheckId);

    List<DeviceCheckVo> searchDeviceCheckByDeviceName(String deviceName);
}