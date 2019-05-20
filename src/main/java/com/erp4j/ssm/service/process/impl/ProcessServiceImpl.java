package com.erp4j.ssm.service.process.impl;

import com.erp4j.ssm.mapper.process.ProcessMapper;
import com.erp4j.ssm.pojo.process.Process;
import com.erp4j.ssm.pojo.process.ProcessExample;
import com.erp4j.ssm.service.process.ProcessService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 15:05
 * @Description:
 */

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public Process queryProcessById(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);
        return process;
    }

    @Override
    public List<Process> queryProcess() {
        List<Process> processes = processMapper.selectByExample(new ProcessExample());
        return processes;
    }

    @Override
    public List<Process> queryProcess(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Process> processes = processMapper.selectByExample(new ProcessExample());
        return processes;
    }

    @Override
    public int queryTotal() {
        int total = (int) processMapper.countByExample(new ProcessExample());
        return total;
    }

    @Override
    public boolean insertProcess(Process process) {
        int result = processMapper.insertSelective(process);
        return result == 1;
    }

    @Override
    public boolean updateProcess(Process process) {
        int result = processMapper.updateByPrimaryKeySelective(process);
        return result == 1;
    }

    @Override
    public boolean deleteMultiProcess(List<String> ids) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdIn(ids);
        int result = processMapper.deleteByExample(processExample);
        return result == ids.size();
    }

    @Override
    public List<Process> queryProcessById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdLike("%" + searchValue + "%");
        List<Process> processes = processMapper.selectByExample(processExample);
        return processes;
    }

    @Override
    public int queryTotalById(String searchValue) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andProcessIdLike("%" + searchValue + "%");
        int total = (int) processMapper.countByExample(processExample);
        return total;
    }

    @Override
    public List<Process> queryProcessByTechnologyPlanId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andTechnologyPlanIdLike("%" + searchValue + "%");
        List<Process> processes = processMapper.selectByExample(processExample);
        return processes;
    }

    @Override
    public int queryTotalByTechnologyPlanId(String searchValue) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        criteria.andTechnologyPlanIdLike("%" + searchValue + "%");
        int total = (int) processMapper.countByExample(processExample);
        return total;
    }
}
