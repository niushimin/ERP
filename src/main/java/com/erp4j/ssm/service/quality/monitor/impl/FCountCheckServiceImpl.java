package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.FinalCountCheckMapper;
import com.erp4j.ssm.pojo.FinalCountCheck;
import com.erp4j.ssm.pojo.FinalCountCheckExample;
import com.erp4j.ssm.service.quality.monitor.FCountCheckService;
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

        ArrayList<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckAll();
        responseVo.setRows(finalCountChecks);

        long count = finalCountCheckMapper.countByExample(new FinalCountCheckExample());
        responseVo.setTotal((int)count);

        return responseVo;
    }
}
