package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceFaultMapper;
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
}
