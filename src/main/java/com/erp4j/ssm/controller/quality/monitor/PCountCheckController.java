package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessCountCheck;
import com.erp4j.ssm.service.quality.monitor.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/p_count_check")
public class PCountCheckController {
    @Autowired
    PCountCheckService pCountCheckService;

    /*工序计数质检*/
    @RequestMapping("/find")
    public String PCountCheckFind(){
        return "p_count_check_list";
    }

    /*返回工序计数列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo<ProcessCountCheck> selectPCountCheckAll(){
        ResponseVo<ProcessCountCheck> responseVo = pCountCheckService.getResponseVo();
        return responseVo;
    }

}
