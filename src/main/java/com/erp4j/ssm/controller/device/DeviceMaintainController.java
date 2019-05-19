package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.DeviceMaintain;
import com.erp4j.ssm.pojo.device.DMVo;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.DeviceMaintainVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, DeviceMaintainVo deviceMaintainVo){
        EUDataGridResult result = deviceMaintainService.getList(page,rows,deviceMaintainVo);
        return result;
    }


    //新增设备维修验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增设备维修
    @RequestMapping("/add")
    public String add() {
        return "deviceMaintain_add";
    }

    //编辑设备维修验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑设备维修
    @RequestMapping("/edit")
    public String edit() {
        return "deviceMaintain_edit";
    }

    //删除设备维修验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(DeviceMaintainVo deviceMaintainVo) {
        boolean flag = deviceMaintainService.updateNote(deviceMaintainVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除设备种类
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(DMVo dmVo) {
        boolean flag = deviceMaintainService.deleteMultiCustom(dmVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //新增设备种类
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(DeviceMaintain deviceMaintain){
        boolean flag = deviceMaintainService.insert(deviceMaintain);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑设备种类
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(DeviceMaintain deviceMaintain){
        boolean flag = deviceMaintainService.update(deviceMaintain);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //根据设备维修编号查找
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page, rows, searchValue);
        return result;
    }

    //根据设备故障编号查找
    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page, rows, searchValue);
        return result;
    }
}
