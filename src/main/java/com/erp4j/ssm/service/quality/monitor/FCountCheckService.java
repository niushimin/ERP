package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.FinalCountCheck;

public interface FCountCheckService {
    ResponseVo getResponseVo(int page, int rows);

    ResponseStatus insertFCountCheck(FinalCountCheck finalMeasuretCheck);

    ResponseStatus updateAllFCountCheck(FinalCountCheck finalCountCheck);

    ResponseStatus deleteBatchFCountCheck(String[] ids);

    ResponseVo searchFCountCheckByFCountCheckId(QueryParameters queryParameters);

    ResponseVo searchFCountCheckByOrderId(QueryParameters queryParameters);
}
