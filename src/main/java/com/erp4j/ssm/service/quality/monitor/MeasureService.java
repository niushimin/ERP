package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.FinalMeasuretCheck;

import java.util.ArrayList;

public interface MeasureService {
    ResponseVo getResponseVo();

    ResponseStatus insertMeasure(FinalMeasuretCheck finalMeasuretCheck);

    ResponseStatus updateAllMeasure(FinalMeasuretCheck finalMeasuretCheck);

    ResponseStatus deleteBatchMeasure(String[] ids);

    ResponseVo searchFMeasureCheckByFMeasureCheckId(QueryParameters queryParameters);
}
