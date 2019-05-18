package com.erp4j.ssm.service.device.impl;

import com.erp4j.ssm.mapper.DeviceMapper;
import com.erp4j.ssm.pojo.Device;
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
}
