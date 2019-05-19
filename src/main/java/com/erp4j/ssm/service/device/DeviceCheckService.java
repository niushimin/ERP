package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.DeviceCheck;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceCheckService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceCheckVo deviceCheckVo);

    boolean updateNote(DeviceCheckVo deviceCheckVo);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(DeviceCheck deviceCheck);

    boolean update(DeviceCheck deviceCheck);

    EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page, Integer rows, String deviceCheckId);

    EUDataGridResult searchDeviceCheckByDeviceName(Integer page, Integer rows, String deviceName);
}
