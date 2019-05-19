package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceMaintainMapper;
import com.erp4j.ssm.pojo.DeviceMaintain;
import com.erp4j.ssm.pojo.DeviceMaintainExample;
import com.erp4j.ssm.pojo.device.DeviceMaintainVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;


    @Override
    public EUDataGridResult getList(Integer page, Integer rows, DeviceMaintainVo deviceMaintainVo) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintainVo> list = deviceMaintainMapper.find(deviceMaintainVo);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<DeviceMaintainVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;


    }

    @Override
    public boolean updateNote(DeviceMaintainVo deviceMaintainVo) {
        int i = deviceMaintainMapper.updateNote(deviceMaintainVo);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceMaintainExample.createCriteria();
        criteria.andDeviceMaintainIdIn(ids);
        int i = deviceMaintainMapper.deleteByExample(deviceMaintainExample);
        return i == ids.size();
    }

    @Override
    public boolean insert(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.insertSelective(deviceMaintain);
        return i == 1;
    }

    @Override
    public boolean update(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page, Integer rows, String deviceMaintainId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceMaintainVo> list = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(deviceMaintainId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceMaintainVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page, Integer rows, String deviceFaultId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceMaintainVo> list = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(deviceFaultId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceMaintainVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
