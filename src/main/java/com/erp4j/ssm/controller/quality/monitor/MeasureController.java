package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.FinalMeasuretCheck;
import com.erp4j.ssm.service.quality.monitor.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/measure")
public class MeasureController {

    @Autowired
    MeasureService measureService;

    /*成品计量质检*/
    @RequestMapping("/find")
    public String measureFind(){
        return "measurement_list";
    }
    /*返回成品计量列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo selectMeasureAll(){
        ResponseVo responseVo = measureService.getResponseVo();
        return responseVo;
    }
}
