package com.erp4j.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
