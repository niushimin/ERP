package com.erp4j.ssm.controller.quality.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class QualityMonitorController {
    /*不合格品管理*/
    @RequestMapping("/unqualify/find")
    public String unqulifyFind(){
        return "unqualify_list";
    }

    /*成品计量质检*/
    @RequestMapping("/measure/find")
    public String measureFind(){

        return null;
    }
    /*成品计数质检*/
    @RequestMapping("/f_count_check/find")
    public String fCountCheckFind(){

        return null;
    }
    /*工序计量质检*/
    @RequestMapping("/p_measure_check/find")
    public String pMeasureCheckFind(){

        return null;
    }
    /*工序计数质检*/
    @RequestMapping("/p_count_check/find")
    public String pCountCheckFind(){

        return null;
    }

}
