package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.DeviceMaintain;
import com.erp4j.ssm.pojo.device.DeviceMaintainVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceMaintainService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceMaintainVo deviceMaintainVo);

    boolean updateNote(DeviceMaintainVo deviceMaintainVo);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(DeviceMaintain deviceMaintain);

    boolean update(DeviceMaintain deviceMaintain);

    EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page, Integer rows, String deviceMaintainId);

    EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page, Integer rows, String deviceFaultId);
}
