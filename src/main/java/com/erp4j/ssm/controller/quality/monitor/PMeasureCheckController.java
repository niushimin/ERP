package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.service.quality.monitor.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("p_measure_check")
public class PMeasureCheckController {
    @Autowired
    PMeasureCheckService pMeasureCheckService;

    /*工序计量质检*/
    @RequestMapping("/find")
    public String pMeasureCheckFind(){
        return "p_measure_check_list";
    }
    /*返回工序计量列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo selectpMeasureCheckAll(){
        ResponseVo responseVo = pMeasureCheckService.getResponseVo();
        return responseVo;
    }
}
