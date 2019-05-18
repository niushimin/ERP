package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

public interface DeviceTypeService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceTypeVo deviceTypeVo);
}
