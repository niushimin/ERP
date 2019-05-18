package com.erp4j.ssm.controller.quality.monitor;


import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/unqualify")
public class UnqulifyController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

    @ResponseBody
    @RequestMapping("/list")
    public UnqualifyApplyPojo[] unqualifyList(int page, int rows){

        UnqualifyApplyPojo[] unqualifyApplyPojos = unqulifyFindService.queryList(page,rows);
        System.out.println(Arrays.toString(unqualifyApplyPojos));
        return unqualifyApplyPojos;
    }
}
