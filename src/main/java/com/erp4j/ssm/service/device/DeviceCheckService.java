package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

public interface DeviceCheckService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceCheckVo deviceCheckVo);
}
