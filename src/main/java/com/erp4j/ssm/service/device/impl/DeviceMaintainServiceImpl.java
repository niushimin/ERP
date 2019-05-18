package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceMaintainMapper;
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
}
