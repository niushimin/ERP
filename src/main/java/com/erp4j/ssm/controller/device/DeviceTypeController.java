package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, DeviceTypeVo deviceTypeVo) {
        EUDataGridResult result = deviceTypeService.getList(page, rows, deviceTypeVo);
        return result;
    }
}
