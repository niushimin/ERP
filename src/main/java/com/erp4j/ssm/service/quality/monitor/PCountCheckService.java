package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessCountCheck;

public interface PCountCheckService {
    ResponseVo<ProcessCountCheck> getResponseVo();
}
