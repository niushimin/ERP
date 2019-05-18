package com.erp4j.ssm.service.work.impl;

import com.erp4j.ssm.mapper.work.WorkMapper;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkExample;
import com.erp4j.ssm.service.work.WorkService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 20:26
 * @Description:
 */

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> queryWork(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.queryWork();
        return works;
    }

    @Override
    public int queryTotal() {
        int result = (int) workMapper.countByExample(new WorkExample());
        return result;
    }
}
