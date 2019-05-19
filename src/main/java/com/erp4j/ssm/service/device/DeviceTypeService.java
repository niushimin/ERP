package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceTypeService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceTypeVo deviceTypeVo);

    DeviceType get(String deviceTypeId);

    List<DeviceType> find();

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(DeviceType deviceType);

    boolean update(DeviceType deviceType);

    EUDataGridResult searchDeviceTypeByDeviceTypeId(Integer page, Integer rows, String deviceTypeId);

    EUDataGridResult searchDeviceTypeByDeviceTypeName(Integer page, Integer rows, String deviceTypeName);

}
