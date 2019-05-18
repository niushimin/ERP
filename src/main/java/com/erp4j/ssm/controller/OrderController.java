package com.erp4j.ssm.controller;

import com.erp4j.ssm.pojo.COrder;
import com.erp4j.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:40
 * @Description:
 */

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/find")
    public String find(Model model) {
        model.addAttribute("page", 1);
        model.addAttribute("rows", 10);
        return "redirect:list";
    }

    @RequestMapping("/order/list")
    @ResponseBody
    public Map<String, Object> list(String page, String rows) {
        int total = orderService.findTotal();
        List<COrder> list = orderService.findRows();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

}