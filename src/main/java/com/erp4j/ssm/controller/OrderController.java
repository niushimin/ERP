package com.erp4j.ssm.controller;

import com.erp4j.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:40
 * @Description:
 */

@Controller
//@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("order/find")
    public String find() {
        return "forward:list";
    }

    @RequestMapping("/list")
    public String list() {
        System.out.println("11111");
        return "order_list";
    }

    @RequestMapping("/")
    public String login() {
        System.out.println("111111111111111111");
        return "";
    }
}
