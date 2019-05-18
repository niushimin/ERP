package com.erp4j.ssm.controller.quality.monitor;


import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.UnqualifyApply;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/unqualify")
public class UnqualifyController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

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
    public String unqualifyAddJudgt(){
        return "msg";
    }

    /*新增不合格品*/
    @RequestMapping("/add")
    public String unqualifyAdd(){
        return "unqualify_add";
    }

    /*修改不合格品验证*/
    @ResponseBody
    @RequestMapping("/edit_judge")
    public String unqualifyEditJudgt(){
        return "msg";
    }
    /*修改不合格品*/
    @RequestMapping("/edit")
    public String unqulifyEdit(){
        return "unqualify_edit";
    }
    /*删除不合格品验证*/
    @ResponseBody
    @RequestMapping("/delete_judge")
    public String unqulifyDeleteJudge(){
        return "msg";
    }
    /*删除不合格品*/
    @RequestMapping("/delete_batch")
    public ResponseStatus unqulifyDelete(String[] ids){
        unqulifyFindService.deleteUnqulifyById(ids);
        ResponseStatus responseStatus = unqulifyFindService.getResponseStatus();
        return responseStatus;
    }
    /*提交添加不合格品数据*/
    @ResponseBody
    @RequestMapping("/insert")
    public ResponseStatus unqulifyInsert(UnqualifyApply unqualifyApply){
        unqulifyFindService.insertUnqulify(unqualifyApply);
        ResponseStatus responseStatus = unqulifyFindService.getResponseStatus();
        return responseStatus;
    }
    /*提交修改不合格品数据*/
    @ResponseBody
    @RequestMapping("update_all")
    public ResponseStatus unqulifyUpdateAll(UnqualifyApply unqualifyApply){
        unqulifyFindService.unqulifyUpdateAll(unqualifyApply);
        ResponseStatus responseStatus = unqulifyFindService.getResponseStatus();
        return responseStatus;
    }

}
