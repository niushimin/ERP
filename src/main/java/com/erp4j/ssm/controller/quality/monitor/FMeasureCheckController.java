package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.service.quality.monitor.FMeasureCheckService;
import com.erp4j.ssm.service.quality.monitor.impl.FMeasureCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fMeasureCheck")
public class FMeasureCheckController {
    @Autowired
    FMeasureCheckService fMeasureCheckService;

    /*成品计量添加验证*/
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String,String> fMeasureCheckAddJudge(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*成品计量修改验证*/
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String,String> fMeasureCheckEditJudge(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*成品计量删除验证*/
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String,String> fMeasureCheckDeleteJudge(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
}
