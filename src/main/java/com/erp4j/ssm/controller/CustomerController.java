package com.erp4j.ssm.controller;

import com.erp4j.ssm.pojo.COrder;
import com.erp4j.ssm.pojo.Custom;
import com.erp4j.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/find")
    public String find(String pageSize, Model model) {
        model.addAttribute("page", 1);
        model.addAttribute("rows", 30);
        return "redirect:list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(String page, String rows) {
        int total = customerService.findTotal();
        List<Custom> list = customerService.findRows();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
