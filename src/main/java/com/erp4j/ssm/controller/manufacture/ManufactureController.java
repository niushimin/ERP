package com.erp4j.ssm.controller.manufacture;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.manufacture.Manufacture;
import com.erp4j.ssm.pojo.manufacture.ManufactureVo;
import com.erp4j.ssm.service.manufacture.ManufactureService;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 14:56
 * @Description:
 */

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    // 从主页查看生产计划列表信息
    @RequestMapping("/find")
    public String find() {
        return "manufacture_list";
    }

    // 返回生产计划列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<Manufacture> list = manufactureService.queryManufacture(page, rows);
        int total = manufactureService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增生产计划权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增生产计划页面
    @RequestMapping("/add")
    public String add() {
        return "manufacture_add";
    }

    // 保存生产计划信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(ManufactureVo manufactureVo) {
        boolean flag = manufactureService.insertManufacture(manufactureVo);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改生产计划权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改生产计划页面
    @RequestMapping("/edit")
    public String edit() {
        return "manufacture_edit";
    }

    // 将修改的生产计划保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(ManufactureVo manufactureVo) {
        boolean flag = manufactureService.updateManufacture(manufactureVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除生产计划权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除生产计划
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = manufactureService.deleteMultiManufacture(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据生产计划Id查询生产计划信息
    @ResponseBody
    @RequestMapping("/get/{manufactureSn}")
    public Manufacture get(@PathVariable("manufactureSn") String manufactureSn) {
        Manufacture manufacture = manufactureService.queryManufactureById(manufactureSn);
        return manufacture;
    }

    // 获取全部生产计划信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Manufacture> get_data() {
        List<Manufacture> list = manufactureService.queryManufacture();
        return list;
    }

    // 根据生产批号查询生产计划信息
    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureSn")
    public Map<String, Object> search_manufacture_by_manufactureSn(String searchValue, int page, int rows) {
        List<Manufacture> list = manufactureService.queryManufactureById(searchValue, page, rows);
        int total = manufactureService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据订单编号查询生产计划信息
    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    public Map<String, Object> search_manufacture_by_manufactureOrderId(String searchValue, int page, int rows) {
        List<Manufacture> list = manufactureService.queryManufactureByOrderId(searchValue, page, rows);
        int total = manufactureService.queryTotalByOrderId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据工艺名称查询生产计划信息
    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    public Map<String, Object> search_manufacture_by_manufactureTechnologyName(String searchValue, int page, int rows) {
        List<Manufacture> list = manufactureService.queryManufactureByTechnologyName(searchValue, page, rows);
        int total = manufactureService.queryTotalByTechnologyName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }



}
