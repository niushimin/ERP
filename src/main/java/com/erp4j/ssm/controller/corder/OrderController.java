package com.erp4j.ssm.controller.corder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/get_data")
    public String orderGetData(){
        return "forward:/corder/get_data";
    }
}
