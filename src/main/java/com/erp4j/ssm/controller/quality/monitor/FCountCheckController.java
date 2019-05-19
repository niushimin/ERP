package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.service.quality.monitor.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/f_count_check")
public class FCountCheckController {
    @Autowired
    FCountCheckService fCountCheckService;
    /*成品计数质检*/
    @RequestMapping("/find")
    public String fCountCheckFind(){
        return "f_count_check_list";
    }
    /*返回成品计数列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo selectMeasureAll(){
        ResponseVo responseVo = fCountCheckService.getResponseVo();
        return responseVo;
    }
}
