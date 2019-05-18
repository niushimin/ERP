package com.erp4j.ssm.service.quality.monitor.impl;

import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;
import com.erp4j.ssm.mapper.quality.monitor.UnqualifyMapper;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnqulifyFindServiceImpl implements UnqulifyFindService {
    @Autowired
    UnqualifyMapper unqualifyMapper;

    /**
     * 返回一个全列表
     * @param page 页数
     * @param rows 每一页行数
     * @return
     */
    @Override
    public UnqualifyApplyPojo[] queryUnqulifyApplyAll(int page, int rows) {
        //PageHelper.startPage(1, 10);
        UnqualifyApplyPojo[] unqualifyApplyQueries = unqualifyMapper.queryUnqulifyApplyAll(page,rows);
        return unqualifyApplyQueries;
    }
}
