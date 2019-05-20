package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.mapper.FinalMeasuretCheckMapper;
import com.erp4j.ssm.pojo.FinalMeasuretCheck;
import com.erp4j.ssm.pojo.FinalMeasuretCheckExample;
import com.erp4j.ssm.service.quality.monitor.MeasureService;
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
}
