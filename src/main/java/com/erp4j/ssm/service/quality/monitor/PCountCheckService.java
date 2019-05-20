package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessCountCheck;

public interface PCountCheckService {
    ResponseVo<ProcessCountCheck> getResponseVo(int page, int rows);

    ResponseStatus insertProcessCountCheck(ProcessCountCheck processCountCheck);

    ResponseStatus updateAllProcessCountCheck(ProcessCountCheck processCountCheck);

    ResponseStatus deleteBatchProcessCountCheck(String[] ids);

    ResponseVo searchPMeasureCheckByPMeasureCheckId(QueryParameters queryParameters);
}
