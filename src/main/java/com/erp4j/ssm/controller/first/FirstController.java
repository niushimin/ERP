package com.erp4j.ssm.controller.first;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/home")
    public String first(){
        return "home";
    }
}
