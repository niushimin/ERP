package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceMapper;
import com.erp4j.ssm.pojo.Device;
import com.erp4j.ssm.pojo.DeviceExample;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public EUDataGridResult findDeviceList(Integer page, Integer rows,DeviceVo deviceVo) {
        //分页处理
        PageHelper.startPage(page,rows);
        List<DeviceVo> deviceList = deviceMapper.findDeviceList(deviceVo);
        //返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(deviceList);
        //取记录总条数
        PageInfo<DeviceVo> pageInfo = new PageInfo<>(deviceList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public boolean updateNote(DeviceVo deviceVo) {
        int i = deviceMapper.updateNote(deviceVo);
        return i == 1;
    }

    @Override
    public List<DeviceVo> find() {
        List<DeviceVo> list = deviceMapper.listType();
        return list;
    }

    @Override
    public boolean insert(Device device) {
        int i = deviceMapper.insertSelective(device);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdIn(ids);
        int i = deviceMapper.deleteByExample(deviceExample);
        return i == ids.size();
    }

    @Override
    public boolean update(Device device) {
        int i = deviceMapper.updateByPrimaryKey(device);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String deviceId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceVo> list = deviceMapper.searchDeviceByDeviceId(deviceId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String deviceName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceVo> list = deviceMapper.searchDeviceByDeviceName(deviceName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String deviceTypeName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceVo> list = deviceMapper.searchDeviceByDeviceTypeName(deviceTypeName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Device get(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    public Device queryDeviceById(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public List<Device> queryDevice() {
        return null;
    }

}
