package com.erp4j.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 18:02
 * @Description:
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ArrayList<String> list = new ArrayList<>();
        /*添加权限*/
        list.add("unqualify:add");
        list.add("unqualify:edit");
        list.add("unqualify:delete");

        list.add("corder:add");
        list.add("corder:edit");
        list.add("corder:delete");

        list.add("custom:add");
        list.add("custom:edit");
        list.add("custom:delete");

        list.add("product:add");
        list.add("product:edit");
        list.add("product:delete");

        session.setAttribute("sysPermissionList",list);
        return "home";
    }
}
