package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.Device;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceService {

    EUDataGridResult findDeviceList(Integer page, Integer rows,DeviceVo deviceVo);
}
