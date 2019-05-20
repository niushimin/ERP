package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.FinalMeasuretCheckMapper;
import com.erp4j.ssm.pojo.FinalMeasuretCheck;
import com.erp4j.ssm.pojo.FinalMeasuretCheckExample;
import com.erp4j.ssm.service.quality.monitor.MeasureService;
import com.erp4j.ssm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MeasureServiceImpl implements MeasureService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public ResponseVo getResponseVo() {
        ResponseVo<FinalMeasuretCheck> finalMeasuretCheckResponseVo = new ResponseVo<>();

        ArrayList<FinalMeasuretCheck>  finalMeasuretChecks= finalMeasuretCheckMapper.selectMeasureAll();
        finalMeasuretCheckResponseVo.setRows(finalMeasuretChecks);

        long count = finalMeasuretCheckMapper.countByExample(new FinalMeasuretCheckExample());
        finalMeasuretCheckResponseVo.setTotal((int)count);

        return finalMeasuretCheckResponseVo;
    }

    @Override
    public ResponseStatus insertMeasure(FinalMeasuretCheck finalMeasuretCheck) {
        if(finalMeasuretCheckMapper.insert(finalMeasuretCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("插入失败","400");
        }
    }

    @Override
    public ResponseStatus updateAllMeasure(FinalMeasuretCheck finalMeasuretCheck) {
        if(finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck) != 0){
            return ResponseUtil.getResponseStatus("OK","200");
        }else {
            return ResponseUtil.getResponseStatus("修改失败","400");
        }
    }

    @Override
    public ResponseStatus deleteBatchMeasure(String[] ids) {
        for (String id : ids) {
            if(finalMeasuretCheckMapper.deleteByPrimaryKey(id) == 0){
                return ResponseUtil.getResponseStatus("修改失败","400");
            }
        }
        return ResponseUtil.getResponseStatus("OK","200");
    }

    @Override
    public ResponseVo searchFMeasureCheckByFMeasureCheckId(QueryParameters queryParameters) {
        ResponseVo<FinalMeasuretCheck> responseVo = new ResponseVo<>();


        return null;
    }
}
