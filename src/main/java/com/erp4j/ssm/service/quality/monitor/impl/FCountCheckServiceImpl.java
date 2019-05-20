package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.FinalCountCheckMapper;
import com.erp4j.ssm.pojo.FinalCountCheck;
import com.erp4j.ssm.pojo.FinalCountCheckExample;
import com.erp4j.ssm.service.quality.monitor.FCountCheckService;
import com.erp4j.ssm.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FCountCheckServiceImpl implements FCountCheckService {

    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public ResponseVo getResponseVo() {
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();

        ArrayList<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckAll(null,null);
        responseVo.setRows(finalCountChecks);

        long count = finalCountCheckMapper.countByExample(new FinalCountCheckExample());
        responseVo.setTotal((int)count);

        return responseVo;
    }

    @Override
    public ResponseStatus insertFCountCheck(FinalCountCheck finalMeasuretCheck) {
        if(finalCountCheckMapper.insert(finalMeasuretCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("插入错误","400");
        }
    }

    @Override
    public ResponseStatus updateAllFCountCheck(FinalCountCheck finalCountCheck) {
        if(finalCountCheckMapper.updateByPrimaryKey(finalCountCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("修改错误","400");
        }
    }

    @Override
    public ResponseStatus deleteBatchFCountCheck(String[] ids) {
        for (String id : ids) {
            if(finalCountCheckMapper.deleteByPrimaryKey(id) == 0){
                return ResponseUtil.getResponseStatus("删除错误","400");
            }
        }
        return ResponseUtil.getResponseStatus("OK","200");
    }

    @Override
    public ResponseVo searchFCountCheckByFCountCheckId(QueryParameters queryParameters) {
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckAll("%" + queryParameters.getSearchValue() + "%", null);
        responseVo.setRows(finalCountChecks);

        int count = finalCountCheckMapper.countFCountCheckById("%" + queryParameters.getSearchValue() + "%",null);
        responseVo.setTotal(count);

        return responseVo;
    }

    @Override
    public ResponseVo searchFCountCheckByOrderId(QueryParameters queryParameters) {
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckAll(null,"%" + queryParameters.getSearchValue() + "%");
        responseVo.setRows(finalCountChecks);

        int count = finalCountCheckMapper.countFCountCheckById(null,"%" + queryParameters.getSearchValue() + "%");
        responseVo.setTotal(count);

        return responseVo;
    }
}
