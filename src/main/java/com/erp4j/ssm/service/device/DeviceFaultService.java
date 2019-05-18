package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

public interface DeviceFaultService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceFaultVo deviceFaultVo);
}
