package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.DeviceCheck;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, DeviceCheckVo deviceCheckVo) {
        EUDataGridResult result = deviceCheckService.getList(page, rows, deviceCheckVo);
        return result;
    }
}
