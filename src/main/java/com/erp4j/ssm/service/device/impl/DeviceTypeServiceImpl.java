package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.DeviceTypeMapper;
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
}
