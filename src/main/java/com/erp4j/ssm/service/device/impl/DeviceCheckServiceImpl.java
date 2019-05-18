package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.device.DeviceCheckMapper;
import com.erp4j.ssm.pojo.DeviceCheck;
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
}
