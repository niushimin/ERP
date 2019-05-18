package com.erp4j.ssm.controller.work;

import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 20:25
 * @Description:
 */

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping("/find")
    public String find() {
        return "work_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map list(int page, int rows) {
        List<Work> list = workService.queryWork(page, rows);
        int total = workService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
