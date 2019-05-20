package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.DeviceFault;
import com.erp4j.ssm.pojo.device.DFVo;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.DeviceFaultVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    //获取设备故障细信息
    @RequestMapping("/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getItemById(@PathVariable String deviceFaultId) {
        DeviceFault device = deviceFaultService.get(deviceFaultId);
        return device;
    }

    //获取所有设备故障信息
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceFault> getData() {
        List<DeviceFault> list = deviceFaultService.find();
        return list;
    }

    //新增设备故障验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增设备故障
    @RequestMapping("/add")
    public String add() {
        return "deviceFault_add";
    }

    //编辑设备故障验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑设备故障
    @RequestMapping("/edit")
    public String edit() {
        return "deviceFault_edit";
    }

    //删除设备故障验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(DeviceFaultVo deviceFaultVo) {
        boolean flag = deviceFaultService.updateNote(deviceFaultVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除设备故障
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(DFVo dfVo) {
        boolean flag = deviceFaultService.deleteMultiCustom(dfVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //新增设备故障
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(DeviceFault deviceFault){
        boolean flag = deviceFaultService.insert(deviceFault);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑设备故障
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(DeviceFault deviceFault){
        boolean flag = deviceFaultService.update(deviceFault);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }


    //编辑设备维修里的设备种类
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String, Object> update_all(DeviceFault deviceFault) {
        boolean flag = deviceFaultService.update(deviceFault);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //根据设备故障id查找
    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = deviceFaultService.searchDeviceFaultByDeviceFaultId(page, rows, searchValue);
        return result;
    }

    //根据设备名查找
    @RequestMapping("/search_deviceFault_by_deviceName")
    @ResponseBody
    public EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = deviceFaultService.searchDeviceFaultByDeviceName(page, rows, searchValue);
        return result;
    }

}
