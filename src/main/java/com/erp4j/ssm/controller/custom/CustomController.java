package com.erp4j.ssm.controller.custom;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.service.custom.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 23:25
 * @Description:
 */
@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map list(int page, int rows) {
        List<Custom> list = customService.queryCustom(page, rows);
        int total = customService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("/add")
    public String add() {
        return "custom_add";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Custom custom) {
        boolean flag = customService.insertCustom(custom);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("/edit")
    public String edit() {
        return "custom_edit";
    }

    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Custom custom) {
        boolean flag = customService.updateCustom(custom);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = customService.deleteMultiCustom(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Custom> get_data() {
        List<Custom> list = customService.queryCustom();
        return list;
    }
}
