package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.FinalCountCheck;
import com.erp4j.ssm.service.quality.monitor.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FCountCheckController {
    @Autowired
    FCountCheckService fCountCheckService;
    /*成品计数质检*/
    @RequestMapping("/f_count_check/find")
    public String fCountCheckFind(){
        return "f_count_check_list";
    }
    /*返回成品计数列表*/
    @ResponseBody
    @RequestMapping("/f_count_check/list")
    public ResponseVo selectMeasureAll(){
        ResponseVo responseVo = fCountCheckService.getResponseVo();
        return responseVo;
    }
    /*成品计数新增校验*/
    @ResponseBody
    @RequestMapping("/fCountCheck/add_judge")
    public Map<String,String> fCountCheckAddJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*成品计数修改校验*/
    @ResponseBody
    @RequestMapping("/fCountCheck/edit_judge")
    public Map<String,String> fCountCheckEditJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*成品计数删除校验*/
    @ResponseBody
    @RequestMapping("/fCountCheck/delete_judge")
    public Map<String,String> fCountCheckDeleteJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*成品计数新增*/
    @RequestMapping("/f_count_check/add")
    public String fCountCheckAdd(){
        return "f_count_check_add";
    }
    /*成品计数修改*/
    @RequestMapping("/f_count_check/edit")
    public String fCountCheckEdit(){
        return "f_count_check_edit";
    }
    /*提交成品计数新增*/
    @ResponseBody
    @RequestMapping("/f_count_check/insert")
    public ResponseStatus insertFCountCheck(FinalCountCheck finalCountCheck){
        ResponseStatus responseStatus = fCountCheckService.insertFCountCheck(finalCountCheck);
        return responseStatus;
    }
    /*提交成品计数修改*/
    @ResponseBody
    @RequestMapping("/f_count_check/update_all")
    public ResponseStatus updateAllFCountCheck(FinalCountCheck finalCountCheck){
        ResponseStatus responseStatus = fCountCheckService.updateAllFCountCheck(finalCountCheck);
        return responseStatus;
    }
    /*提交成品计数删除*/
    @ResponseBody
    @RequestMapping("/f_count_check/delete_batch")
    public ResponseStatus deleteBatchFCountCheck(String[] ids){
        ResponseStatus responseStatus = fCountCheckService.deleteBatchFCountCheck(ids);
        return responseStatus;
    }
    /*根据成品计数质检编号查询成品计数*/
    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_fCountCheckId")
    public ResponseVo searchFCountCheckByFCountCheckId(QueryParameters queryParameters){
        ResponseVo responseVo = fCountCheckService.searchFCountCheckByFCountCheckId(queryParameters);
        return responseVo;
    }
    /*根据订单编号查询成品计数*/
    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    public ResponseVo searchFCountCheckByOrderId(QueryParameters queryParameters){
        ResponseVo responseVo = fCountCheckService.searchFCountCheckByOrderId(queryParameters);
        return responseVo;
    }
}
