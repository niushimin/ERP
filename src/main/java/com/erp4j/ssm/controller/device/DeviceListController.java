
package com.erp4j.ssm.controller.device;

import com.erp4j.ssm.pojo.Device;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult findDeviceList(Integer page,Integer rows,DeviceVo deviceVo){
        EUDataGridResult result = deviceService.findDeviceList(page, rows,deviceVo);
        return result;
    }
}

