package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceFaultMapper;
import com.erp4j.ssm.pojo.DeviceFault;
import com.erp4j.ssm.pojo.DeviceFaultExample;
import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceFaultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    
    @Override
    public EUDataGridResult getList(Integer page, Integer rows, DeviceFaultVo deviceFaultVo) {
        PageHelper.startPage(page,rows);
        List<DeviceFaultVo> list = deviceFaultMapper.find(deviceFaultVo);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<DeviceFaultVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;


    }

    @Override
    public boolean updateNote(DeviceFaultVo deviceFaultVo) {
        int i = deviceFaultMapper.updateNote(deviceFaultVo);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceFaultExample.createCriteria();
        criteria.andDeviceFaultIdIn(ids);
        int i = deviceFaultMapper.deleteByExample(deviceFaultExample);
        return i == ids.size();
    }

    @Override
    public boolean insert(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insertSelective(deviceFault);
        return i == 1;
    }

    @Override
    public boolean update(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKey(deviceFault);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String deviceFaultId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceFaultVo> list = deviceFaultMapper.searchDeviceFaultByDeviceFaultId(deviceFaultId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceFaultVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows, String deviceName) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<DeviceFaultVo> list = deviceFaultMapper.searchDeviceFaultByDeviceName(deviceName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DeviceFaultVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public DeviceFault get(String deviceFaultId) {
        return deviceFaultMapper.selectByPrimaryKey(deviceFaultId);
    }

    @Override
    public List<DeviceFault> find() {
        List<DeviceFault> list = deviceFaultMapper.listType();
        return list;
    }
}
