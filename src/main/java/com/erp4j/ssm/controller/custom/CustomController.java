package com.erp4j.ssm.controller.custom;

import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.service.customer.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/add_judge")
    public String add_judge() {
        return "custom_add";
    }

    @RequestMapping("/add")
    public String add() {
        return "custom_add";
    }

    @RequestMapping("/insert")
    public String insert(Custom custom) {
        boolean flag = customService.insertCustom(custom);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return "custom_list";
    }
}
