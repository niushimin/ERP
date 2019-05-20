package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.ProcessCountCheckMapper;
import com.erp4j.ssm.mapper.ProcessMeasureCheckMapper;
import com.erp4j.ssm.pojo.ProcessCountCheckExample;
import com.erp4j.ssm.pojo.ProcessMeasureCheck;
import com.erp4j.ssm.pojo.ProcessMeasureCheckExample;
import com.erp4j.ssm.service.quality.monitor.PMeasureCheckService;
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

        ArrayList<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckMapper.selectpMeasureCheckAll();
        responseVo.setRows(processMeasureChecks);

        long count = processMeasureCheckMapper.countByExample(new ProcessMeasureCheckExample());
        responseVo.setTotal((int)count);
        return responseVo;
    }
}
