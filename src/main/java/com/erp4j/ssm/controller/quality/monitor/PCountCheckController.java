package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessCountCheck;
import com.erp4j.ssm.service.quality.monitor.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PCountCheckController {
    @Autowired
    PCountCheckService pCountCheckService;

    /*工序计数质检*/
    @RequestMapping("/p_count_check/find")
    public String PCountCheckFind(){
        return "p_count_check_list";
    }

    /*返回工序计数列表*/
    @ResponseBody
    @RequestMapping("/p_count_check/list")
    public ResponseVo<ProcessCountCheck> selectPCountCheckAll(){
        ResponseVo<ProcessCountCheck> responseVo = pCountCheckService.getResponseVo();
        return responseVo;
    }
    /*工序计数新增校验*/
    @ResponseBody
    @RequestMapping("/pCountCheck/add_judge")
    public Map<String,String> pCountCheckAddJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计数修改校验*/
    @ResponseBody
    @RequestMapping("/pCountCheck/edit_judge")
    public Map<String,String> pCountCheckEditJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计数删除校验*/
    @ResponseBody
    @RequestMapping("/pCountCheck/delete_judge")
    public Map<String,String> pCountCheckEeleteJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*工序计数新增*/
    @RequestMapping("/p_count_check/add")
    public String pCountCheckAdd(){
        return "p_count_check_add";
    }
    /*工序计数修改*/
    @RequestMapping("/p_count_check/edit")
    public String pCountCheckEdit(){
        return "p_count_check_edit";
    }

    /*提交工序计数新增*/
    @ResponseBody
    @RequestMapping("/p_count_check/insert")
    public ResponseStatus insertProcessCountCheck(ProcessCountCheck processCountCheck){
        ResponseStatus responseStatus = pCountCheckService.insertProcessCountCheck(processCountCheck);
        return responseStatus;
    }
    /*提交工序计数新增*/
    @ResponseBody
    @RequestMapping("/p_count_check/update_all")
    public ResponseStatus updateAllProcessCountCheck(ProcessCountCheck processCountCheck){
        ResponseStatus responseStatus = pCountCheckService.updateAllProcessCountCheck(processCountCheck);
        return responseStatus;
    }
    /*提交工序计数删除*/
    @ResponseBody
    @RequestMapping("/p_count_check/delete_batch")
    public ResponseStatus deleteBatchProcessCountCheck(String[] ids){
        ResponseStatus responseStatus = pCountCheckService.deleteBatchProcessCountCheck(ids);
        return responseStatus;
    }

    /*根据工序计数编号查询工序计数*/
    @ResponseBody
    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    public ResponseVo searchPCountCheckByPCountCheckId(QueryParameters queryParameters){
        ResponseVo responseVo = pCountCheckService.searchPMeasureCheckByPMeasureCheckId(queryParameters);
        return responseVo;
    }
}
