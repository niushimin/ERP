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
        list.add("fMeasureCheck:add");
        list.add("fMeasureCheck:edit");
        list.add("fMeasureCheck:delete");

        list.add("fCountCheck:add");
        list.add("fCountCheck:edit");
        list.add("fCountCheck:delete");

        list.add("pMeasureCheck:add");
        list.add("pMeasureCheck:edit");
        list.add("pMeasureCheck:delete");

        list.add("pCountCheck:add");
        list.add("pCountCheck:edit");
        list.add("pCountCheck:delete");

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

        list.add("technology:add");
        list.add("technology:edit");
        list.add("technology:delete");

        list.add("technologyRequirement:add");
        list.add("technologyRequirement:edit");
        list.add("technologyRequirement:delete");

        list.add("technologyPlan:add");
        list.add("technologyPlan:edit");
        list.add("technologyPlan:delete");

        list.add("process:add");
        list.add("process:edit");
        list.add("process:delete");
        //设备管理

        list.add("manufacture:add");
        list.add("manufacture:edit");
        list.add("manufacture:delete");

        list.add("task:add");
        list.add("task:edit");
        list.add("task:delete");

        list.add("department:add");
        list.add("department:edit");
        list.add("department:delete");

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

        list.add("work:add");
        list.add("work:edit");
        list.add("work:delete");

        list.add("material:add");
        list.add("material:edit");
        list.add("material:delete");

        list.add("materialReceive:add");
        list.add("materialReceive:edit");
        list.add("materialReceive:delete");

        list.add("materialConsume:add");
        list.add("materialConsume:edit");
        list.add("materialConsume:delete");

        session.setAttribute("sysPermissionList",list);
        return "home";
    }
}
