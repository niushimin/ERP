package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.DeviceFault;
import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceFaultService {
    EUDataGridResult getList(Integer page, Integer rows, DeviceFaultVo deviceFaultVo);

    boolean updateNote(DeviceFaultVo deviceFaultVo);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(DeviceFault deviceFault);

    boolean update(DeviceFault deviceFault);

    EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String deviceFaultId);

    EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows, String deviceName);

    DeviceFault get(String deviceFaultId);

    List<DeviceFault> find();
}
