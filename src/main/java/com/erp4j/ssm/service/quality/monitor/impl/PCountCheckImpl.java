package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.ProcessCountCheckMapper;
import com.erp4j.ssm.pojo.ProcessCountCheck;
import com.erp4j.ssm.pojo.ProcessCountCheckExample;
import com.erp4j.ssm.service.quality.monitor.PCountCheckService;
import com.erp4j.ssm.util.ResponseUtil;
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

    @Override
    public ResponseStatus insertProcessCountCheck(ProcessCountCheck processCountCheck) {
        if(processCountCheckMapper.insert(processCountCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("插入错误","400");
        }
    }

    @Override
    public ResponseStatus updateAllProcessCountCheck(ProcessCountCheck processCountCheck) {
        if(processCountCheckMapper.updateByPrimaryKey(processCountCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("修改错误","400");
        }
    }

    @Override
    public ResponseStatus deleteBatchProcessCountCheck(String[] ids) {
        for (String id : ids) {
            if(processCountCheckMapper.deleteByPrimaryKey(id) == 0){
                return ResponseUtil.getResponseStatus("删除错误","400");
            }
        }
        return ResponseUtil.getResponseStatus("OK","200");
    }
}
