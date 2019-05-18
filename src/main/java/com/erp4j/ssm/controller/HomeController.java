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

<<<<<<< HEAD
        //设备管理
        list.add("device:add");
        list.add("device:edit");
        list.add("device:delete");

        list.add("deviceType:add");
        list.add("deviceType:edit");
        list.add("deviceType:delete");

        list.add("deviceCheck:add");
        list.add("deviceCheck:edit");
        list.add("deviceCheck:delete");

        list.add("deviceFault:add");
        list.add("deviceFault:edit");
        list.add("deviceFault:delete");

        list.add("deviceMaintain:add");
        list.add("deviceMaintain:edit");
        list.add("deviceMaintain:delete");
=======

        list.add("work:add");
        list.add("work:edit");
        list.add("work:delete");
>>>>>>> 6f63bab88135148464543610a8522303cbfb6bde

        session.setAttribute("sysPermissionList",list);
        return "home";
    }
}
