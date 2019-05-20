
package com.erp4j.ssm.controller.device;

import com.erp4j.ssm.pojo.Device;
import com.erp4j.ssm.pojo.DeviceType;
import com.erp4j.ssm.pojo.device.DVo;
import com.erp4j.ssm.pojo.device.DeviceTypeVo;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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


    //获取所有设备信息
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceVo> getData() {
        List<DeviceVo> list = deviceService.find();
        return list;
    }


    //获取设备详细信息
    @RequestMapping("/get/{deviceId}")
    @ResponseBody
    public Device getItemById(@PathVariable String deviceId) {
        Device device = deviceService.get(deviceId);
        return device;
    }

    //新增设备验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增设备
    @RequestMapping("/add")
    public String add() {
        return "deviceList_add";
    }

    //编辑设备验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑设备
    @RequestMapping("/edit")
    public String edit() {
        return "deviceList_edit";
    }

    //删除设备验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(DeviceVo deviceVo) {
        boolean flag = deviceService.updateNote(deviceVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除设备
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(DVo dVo) {
        boolean flag = deviceService.deleteMultiCustom(dVo.getIds());
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
    public Map<String,Object> insert(Device device){
        boolean flag = deviceService.insert(device);
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
    public Map<String,Object> update(Device device){
        boolean flag = deviceService.update(device);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑设备例检里的设备
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String, Object> update_all(Device device) {
        boolean flag = deviceService.update(device);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //根据设备编号查找设备
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String searchValue) {
        EUDataGridResult result = deviceService.searchDeviceByDeviceId(page, rows, searchValue);
        return result;
    }

    //根据设备名称查找设备
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String searchValue) {
        EUDataGridResult result = deviceService.searchDeviceByDeviceName(page, rows, searchValue);
        return result;
    }

    //根据设备种类名称查找设备
    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String searchValue) {
        EUDataGridResult result = deviceService.searchDeviceByDeviceTypeName(page, rows, searchValue);
        return result;
    }

}

