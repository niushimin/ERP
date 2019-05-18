package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.device.DeviceMaintainVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

public interface DeviceMaintainService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceMaintainVo deviceMaintainVo);
}
