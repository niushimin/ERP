package com.erp4j.ssm.mapper.device;

import com.erp4j.ssm.pojo.DeviceFault;
import com.erp4j.ssm.pojo.DeviceFaultExample;
import java.util.List;

import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultMapper {

    List<DeviceFaultVo> find(DeviceFaultVo deviceFaultVo);















    //逆向工程生成
    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);


}