package com.erp4j.ssm.mapper.device;

import com.erp4j.ssm.pojo.DeviceMaintain;
import com.erp4j.ssm.pojo.DeviceMaintainExample;
import java.util.List;

import com.erp4j.ssm.pojo.device.DeviceMaintainVo;
import org.apache.ibatis.annotations.Param;

public interface DeviceMaintainMapper {

    List<DeviceMaintainVo> find(DeviceMaintainVo deviceMaintainVo);

















    //逆向工程生成
    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);


}