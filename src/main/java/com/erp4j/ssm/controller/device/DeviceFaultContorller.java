package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultContorller {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, DeviceFaultVo deviceFaultVo) {
        EUDataGridResult result = deviceFaultService.getList(page, rows, deviceFaultVo);
        return result;
    }
}
