package com.erp4j.ssm.controller.device;


import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.device.DTVo;
import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    //返回设备种类列表
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, DeviceTypeVo deviceTypeVo) {
        EUDataGridResult result = deviceTypeService.getList(page, rows, deviceTypeVo);
        return result;
    }

    //获取设备种类详细信息
    @RequestMapping("/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType getItemById(@PathVariable String deviceTypeId) {
        DeviceType device = deviceTypeService.get(deviceTypeId);
        return device;
    }

    //获取所有设备种类信息
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> getData() {
        List<DeviceType> list = deviceTypeService.find();
        return list;
    }

    //新增设备种类验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增设备种类
    @RequestMapping("/add")
    public String add() {
        return "deviceType_add";
    }

    //编辑设备种类验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑设备种类
    @RequestMapping("/edit")
    public String edit() {
        return "deviceType_edit";
    }

    //删除设备种类验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //删除设备种类
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(DTVo dtVo) {
        boolean flag = deviceTypeService.deleteMultiCustom(dtVo.getIds());
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
    public Map<String,Object> insert(DeviceType deviceType){
        boolean flag = deviceTypeService.insert(deviceType);
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
    public Map<String,Object> update(DeviceType deviceType){
        boolean flag = deviceTypeService.update(deviceType);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑设备台账里的设备种类
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String, Object> update_all(DeviceType deviceType) {
        boolean flag = deviceTypeService.update(deviceType);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //根据设备种类编号查找
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public EUDataGridResult searchDeviceTypeByDeviceTypeId
    (Integer page, Integer rows, String searchValue) {
        EUDataGridResult result =
                deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
        return result;
    }

    //根据设备种类名称查找
    @RequestMapping("/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public EUDataGridResult searchDeviceTypeByDeviceTypeName
    (Integer page, Integer rows, String searchValue) {
        EUDataGridResult result =
                deviceTypeService.searchDeviceTypeByDeviceTypeName(page, rows, searchValue);
        return result;
    }

}
