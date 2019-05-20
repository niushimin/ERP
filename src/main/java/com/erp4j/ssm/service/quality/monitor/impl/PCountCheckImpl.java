package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.ProcessCountCheckMapper;
import com.erp4j.ssm.pojo.ProcessCountCheck;
import com.erp4j.ssm.pojo.ProcessCountCheckExample;
import com.erp4j.ssm.service.quality.monitor.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PCountCheckImpl implements PCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public ResponseVo<ProcessCountCheck> getResponseVo() {
        ResponseVo<ProcessCountCheck> responseVo = new ResponseVo<>();

        ArrayList<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectPCountCheckAll();
        responseVo.setRows(processCountChecks);

        long count = processCountCheckMapper.countByExample(new ProcessCountCheckExample());
        responseVo.setTotal((int)count);

        return responseVo;
    }
}
