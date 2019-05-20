package com.erp4j.ssm.controller.quality.monitor;


import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.UnqualifyApply;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/unqualify")
public class UnqualifyController {

    /*增删改查返回信息*/
    ResponseStatus responseStatus;

    @Autowired
    UnqulifyFindService unqulifyFindService;

    /*不合格品管理*/
    @RequestMapping("/find")
    public String unqulifyFind(){
        return "unqualify_list";
    }
    /*返回不合格品列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo unqualifyList(int page, int rows){
        ResponseVo responseVo = unqulifyFindService.getResponseVo(page,rows);
        return responseVo;
    }

    /*新增不合格品验证*/
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String,String> unqualifyAddJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }

    /*新增不合格品*/
    @RequestMapping("/add")
    public String unqualifyAdd(){
        return "unqualify_add";
    }

    /*修改不合格品验证*/
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, String> unqualifyEditJudgt(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }

    /*修改不合格品*/
    @RequestMapping("/edit")
    public String unqulifyEdit(){
        return "unqualify_edit";
    }

    /*删除不合格品验证*/
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, String> unqulifyDeleteJudge(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }

    /*删除不合格品*/
    @ResponseBody
    @RequestMapping("/delete_batch")
    public ResponseStatus unqulifyDelete(String[] ids){
        if(unqulifyFindService.deleteUnqulifyById(ids)){
            responseStatus = unqulifyFindService.getResponseStatus("OK","200");
        }else {
            responseStatus = unqulifyFindService.getResponseStatus("删除失败","400");
        }
        return responseStatus;
    }

    /*提交添加不合格品数据*/
    @ResponseBody
    @RequestMapping("/insert")
    public ResponseStatus unqulifyInsert(UnqualifyApply unqualifyApply){
        if(unqulifyFindService.insertUnqulify(unqualifyApply)){
            responseStatus = unqulifyFindService.getResponseStatus("OK","200");
        }else {
            responseStatus = unqulifyFindService.getResponseStatus("添加失败","400");
        }
        return responseStatus;
    }

    /*提交修改不合格品数据*/
    @ResponseBody
    @RequestMapping("update_all")
    public ResponseStatus unqulifyUpdateAll(UnqualifyApply unqualifyApply){
        if(unqulifyFindService.unqulifyUpdateAll(unqualifyApply)){
            responseStatus = unqulifyFindService.getResponseStatus("OK","200");
        }else {
            responseStatus = unqulifyFindService.getResponseStatus("修改失败","400");
        }
        return responseStatus;
    }
    /*根据不合格品编号查询不合格品*/
    @ResponseBody
    @RequestMapping("/search_unqualify_by_unqualifyId")
    public ResponseVo searchUnqualifyByUnqualifyId(QueryParameters queryParameters){
        ResponseVo responseVo = unqulifyFindService.searchUnqualifyByUnqualifyId(queryParameters);
        return responseVo;
    }
    /*根据产品名称查询不合格品*/
    @ResponseBody
    @RequestMapping("/search_unqualify_by_productName")
    public ResponseVo searchUnqualifyByProductName(QueryParameters queryParameters){
        ResponseVo responseVo = unqulifyFindService.searchUnqualifyByProductName(queryParameters);
        return responseVo;
    }
}
