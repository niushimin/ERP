package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.FinalMeasuretCheck;
import com.erp4j.ssm.pojo.ProcessMeasureCheck;
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
    /*新增成品计量*/
    @RequestMapping("/add")
    public String addMeasure(){
        return "measurement_add";
    }
    /*提交新增成品计量*/
    @ResponseBody
    @RequestMapping("/insert")
    public ResponseStatus insertMeasure(FinalMeasuretCheck finalMeasuretCheck){
        ResponseStatus responseStatus = measureService.insertMeasure(finalMeasuretCheck);
        return responseStatus;
    }
    /*提交修改成品计量*/
    @ResponseBody
    @RequestMapping("/update_all")
    public ResponseStatus updateAllMeasure(FinalMeasuretCheck finalMeasuretCheck){
        ResponseStatus responseStatus = measureService.updateAllMeasure(finalMeasuretCheck);
        return responseStatus;
    }
    /*提交删除成品计量*/
    @ResponseBody
    @RequestMapping("/delete_batch")
    public ResponseStatus deleteBatchMeasure(String[] ids){
        ResponseStatus responseStatus = measureService.deleteBatchMeasure(ids);
        return responseStatus;
    }
    /*修改成品计量*/
    @RequestMapping("/edit")
    public String editMeasure(){
        return "measurement_edit";
    }
    /*根据成品计量质检编号查询成品计量*/
    @ResponseBody
    @RequestMapping("/search_fMeasureCheck_by_fMeasureCheckId")
    public ResponseVo searchFMeasureCheckByFMeasureCheckId(QueryParameters queryParameters){
        ResponseVo responseVo = measureService.searchFMeasureCheckByFMeasureCheckId(queryParameters);
        return responseVo;
    }
    /*根据订单编号查询成品计量*/
    @ResponseBody
    @RequestMapping("/search_fMeasureCheck_by_orderId")
    public ResponseVo searchFMeasureCheckByOrderId(QueryParameters queryParameters){
        ResponseVo responseVo = measureService.searchFMeasureCheckByOrderId(queryParameters);
        return responseVo;
    }
}
