package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.ProcessMeasureCheck;

public interface PMeasureCheckService {
    ResponseVo getResponseVo();

    ResponseStatus insertProcessMeasure(ProcessMeasureCheck processMeasureCheck);

    ResponseStatus updateAllProcessMeasure(ProcessMeasureCheck processMeasureCheck);

    ResponseStatus deleteBatchProcessMeasure(String[] ids);

    ResponseVo searchPMeasureCheckByPMeasureCheckId(QueryParameters queryParameters);
}
