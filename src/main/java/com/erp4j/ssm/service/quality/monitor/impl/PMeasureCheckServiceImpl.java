package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.ProcessCountCheckMapper;
import com.erp4j.ssm.mapper.ProcessMeasureCheckMapper;
import com.erp4j.ssm.pojo.ProcessCountCheckExample;
import com.erp4j.ssm.pojo.ProcessMeasureCheck;
import com.erp4j.ssm.pojo.ProcessMeasureCheckExample;
import com.erp4j.ssm.service.quality.monitor.PMeasureCheckService;
import com.erp4j.ssm.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PMeasureCheckServiceImpl implements PMeasureCheckService {

    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public ResponseVo getResponseVo() {
        ResponseVo<ProcessMeasureCheck> responseVo = new ResponseVo<>();

        ArrayList<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectpMeasureCheckAll(null);
        responseVo.setRows(processMeasureChecks);

        long count = processMeasureCheckMapper.countByExample(new ProcessMeasureCheckExample());
        responseVo.setTotal((int)count);
        return responseVo;
    }

    @Override
    public ResponseStatus insertProcessMeasure(ProcessMeasureCheck processMeasureCheck) {
        if(processMeasureCheckMapper.insert(processMeasureCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else{
            return ResponseUtil.getResponseStatus("插入错误","400");
        }
    }

    @Override
    public ResponseStatus updateAllProcessMeasure(ProcessMeasureCheck processMeasureCheck) {
        if(processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else{
            return ResponseUtil.getResponseStatus("修改错误","400");
        }
    }

    @Override
    public ResponseStatus deleteBatchProcessMeasure(String[] ids) {
        for (String id : ids) {
            if(processMeasureCheckMapper.deleteByPrimaryKey(id) == 0){
                return ResponseUtil.getResponseStatus("删除错误","400");
            }
        }
        return ResponseUtil.getResponseStatus("OK","200");
    }

    @Override
    public ResponseVo searchPMeasureCheckByPMeasureCheckId(QueryParameters queryParameters) {
        ResponseVo<ProcessMeasureCheck> responseVo = new ResponseVo<>();

        PageHelper.startPage(queryParameters.getPage(),queryParameters.getRows());
        ArrayList<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectpMeasureCheckAll("%" + queryParameters.getSearchValue() + "%");
        responseVo.setRows(processMeasureChecks);

        int count = processMeasureCheckMapper.countPMeasureCheckById("%" + queryParameters.getSearchValue() + "%");
        responseVo.setTotal(count);

        return responseVo;
    }
}
