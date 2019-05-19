package com.erp4j.ssm.service.work.impl;

import com.erp4j.ssm.mapper.work.WorkMapper;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkExample;
import com.erp4j.ssm.pojo.work.WorkVo;
import com.erp4j.ssm.service.work.WorkService;
import com.github.pagehelper.PageHelper;
import javafx.concurrent.Worker;
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

    @Override
    public boolean deleteMultiWork(List<String> ids) {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdIn(ids);
        int result = workMapper.deleteByExample(workExample);
        return result == ids.size();
    }

    @Override
    public boolean insertWork(WorkVo workVo) {
        int result = workMapper.insertWork(workVo);
        return result == 1;
    }

    @Override
    public boolean updateWork(WorkVo workVo) {
        int result = workMapper.updateWork(workVo);
        return result == 1;
    }

    @Override
    public List<Work> queryWorkById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.queryCOrderById(searchValue);
        return works;
    }

    @Override
    public int queryTotalById(String searchValue) {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdLike("%" + searchValue + "%");
        int total = (int) workMapper.countByExample(workExample);
        return total;
    }

    @Override
    public List<Work> queryWorkByProduct(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.queryWorkByProduct(searchValue);
        return works;
    }

    @Override
    public int queryTotalByProduct(String searchValue) {
        int total = workMapper.queryTotalByProduct(searchValue);
        return total;
    }

    @Override
    public List<Work> queryWorkByDevice(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.queryWorkByDevice(searchValue);
        return works;
    }

    @Override
    public int queryTotalDevice(String searchValue) {
        int total = workMapper.queryTotalByDevice(searchValue);
        return total;
    }

    @Override
    public List<Work> queryWorkByProcess(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Work> works = workMapper.queryWorkByProcess(searchValue);
        return works;
    }

    @Override
    public int queryTotalProcess(String searchValue) {
        int total = workMapper.queryTotalByProcess(searchValue);
        return total;
    }
}
