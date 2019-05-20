package com.erp4j.ssm.service.device;

import com.erp4j.ssm.pojo.Device;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface DeviceService {

    EUDataGridResult findDeviceList(Integer page, Integer rows,DeviceVo deviceVo);

<<<<<<< HEAD

=======
>>>>>>> 57660e6948a20d13f481d8fc0deb94a95d84a205
    boolean updateNote(DeviceVo deviceVo);

    List<DeviceVo> find();

    boolean insert(Device device);

    boolean deleteMultiCustom(List<String> ids);

    boolean update(Device device);

    EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String searchValue);

    EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String searchValue);

    EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String searchValue);

    Device get(String deviceId);

    Device queryDeviceById(String deviceId);

    List<Device> queryDevice();
<<<<<<< HEAD
=======


>>>>>>> 57660e6948a20d13f481d8fc0deb94a95d84a205
}
