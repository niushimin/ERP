package com.erp4j.ssm.controller.quality.monitor;


import com.erp4j.ssm.mapper.COrderMapper;
import com.erp4j.ssm.pojo.COrderExample;
import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/unqualify")
public class UnqulifyController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

    @ResponseBody
    @RequestMapping("/list")
    public Map<String,Object> unqualifyList(int page, int rows){

        UnqualifyApplyPojo[] unqualifyApplyPojos = unqulifyFindService.queryUnqulifyApplyAll(page,rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total",9);
        map.put("rows",unqualifyApplyPojos);
        return map;
    }
}
