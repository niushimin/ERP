package com.ethan.ssm.controller;

import com.ethan.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Ethan New
 * @Date: 2019/5/15 21:46
 * @Description:
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        boolean flag = userService.login(username, password);
        if (flag) {
            model.addAttribute("username", username);
            return "hello";
        } else {
            return "login";
        }
    }
}
