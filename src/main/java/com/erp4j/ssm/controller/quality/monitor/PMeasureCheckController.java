package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessMeasureCheck;
import com.erp4j.ssm.service.quality.monitor.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PMeasureCheckController {
    @Autowired
    PMeasureCheckService pMeasureCheckService;

    /*工序计量质检*/
    @RequestMapping("/p_measure_check/find")
    public String pMeasureCheckFind(){
        return "p_measure_check_list";
    }
    /*返回工序计量列表*/
    @ResponseBody
    @RequestMapping("/p_measure_check/list")
    public ResponseVo selectpMeasureCheckAll(){
        ResponseVo responseVo = pMeasureCheckService.getResponseVo();
        return responseVo;
    }
    /*工序计量新增校验*/
    @ResponseBody
    @RequestMapping("/pMeasureCheck/add_judge")
    public Map<String,String> pMeasureCheckAddJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计量修改校验*/
    @ResponseBody
    @RequestMapping("/pMeasureCheck/edit_judge")
    public Map<String,String> pMeasureCheckEditJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计量删除校验*/
    @ResponseBody
    @RequestMapping("/pMeasureCheck/delete_judge")
    public Map<String,String> pMeasureCheckDeleteJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计量新增*/
    @RequestMapping("/p_measure_check/add")
    public String pMeasureCheckAdd(){
        return "p_measure_check_add";
    }
    /*工序计量修改*/
    @RequestMapping("/p_measure_check/edit")
    public String pMeasureCheckEdit(){
        return "p_measure_check_edit";
    }
    /*提交工序计量新增*/
    @ResponseBody
    @RequestMapping("/p_measure_check/insert")
    public ResponseStatus insertProcessMeasure(ProcessMeasureCheck processMeasureCheck){
        ResponseStatus responseStatus = pMeasureCheckService.insertProcessMeasure(processMeasureCheck);
        return responseStatus;
    }
    /*提交工序计量修改*/
    @ResponseBody
    @RequestMapping("/p_measure_check/update_all")
    public ResponseStatus updateAllProcessMeasure(ProcessMeasureCheck processMeasureCheck){
        ResponseStatus responseStatus = pMeasureCheckService.updateAllProcessMeasure(processMeasureCheck);
        return responseStatus;
    }
    /*提交工序计量删除*/
    @ResponseBody
    @RequestMapping("/p_measure_check/delete_batch")
    public ResponseStatus deleteBatchProcessMeasure(String[] ids){
        ResponseStatus responseStatus = pMeasureCheckService.deleteBatchProcessMeasure(ids);
        return responseStatus;
    }
}
