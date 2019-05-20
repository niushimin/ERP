package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceTypeMapper;
import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.DeviceTypeExample;
import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;


    @Override
    public EUDataGridResult getList(Integer page, Integer rows, DeviceTypeVo deviceTypeVo) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceTypeVo> list = deviceTypeMapper.find(deviceTypeVo);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceTypeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public DeviceType get(String deviceTypeId) {
        return deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
    }

    @Override
    public List<DeviceType> find() {
        List<DeviceType> list = deviceTypeMapper.listType();
        return list;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdIn(ids);
        int i = deviceTypeMapper.deleteByExample(deviceTypeExample);
        return i == ids.size();
    }

    //insertSelective只会插入数据不为null的字段值
    @Override
    public boolean insert(DeviceType deviceType) {
        int i = deviceTypeMapper.insertSelective(deviceType);
        return i == 1;
    }

    @Override
    public boolean update(DeviceType deviceType) {
        int i = deviceTypeMapper.updateByPrimaryKey(deviceType);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchDeviceTypeByDeviceTypeId(Integer page, Integer rows, String deviceTypeId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceTypeVo> list = deviceTypeMapper.searchDeviceTypeByDeviceTypeId(deviceTypeId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceTypeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceTypeByDeviceTypeName(Integer page, Integer rows, String deviceTypeName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceTypeVo> list = deviceTypeMapper.searchDeviceTypeByDeviceTypeName(deviceTypeName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceTypeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
