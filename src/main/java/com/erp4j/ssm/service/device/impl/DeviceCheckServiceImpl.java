package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceCheckMapper;
import com.erp4j.ssm.pojo.DeviceCheck;
import com.erp4j.ssm.pojo.DeviceCheckExample;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows, DeviceCheckVo deviceCheckVo) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceCheckVo> list = deviceCheckMapper.find(deviceCheckVo);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceCheckVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public boolean updateNote(DeviceCheckVo deviceCheckVo) {
        int i = deviceCheckMapper.updateNote(deviceCheckVo);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = deviceCheckExample.createCriteria();
        criteria.andDeviceCheckIdIn(ids);
        int i = deviceCheckMapper.deleteByExample(deviceCheckExample);
        return i == ids.size();
    }

    @Override
    public boolean insert(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.insertSelective(deviceCheck);
        return i == 1;
    }

    @Override
    public boolean update(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page, Integer rows, String deviceCheckId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceCheckVo> list = deviceCheckMapper.searchDeviceCheckByDeviceCheckId(deviceCheckId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceCheckVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceCheckByDeviceName(Integer page, Integer rows, String deviceName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceCheckVo> list = deviceCheckMapper.searchDeviceCheckByDeviceName(deviceName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceCheckVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
