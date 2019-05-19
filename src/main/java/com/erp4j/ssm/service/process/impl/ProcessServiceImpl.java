package com.erp4j.ssm.service.process.impl;

import com.erp4j.ssm.mapper.process.ProcessMapper;
import com.erp4j.ssm.pojo.process.Process;
import com.erp4j.ssm.pojo.process.ProcessExample;
import com.erp4j.ssm.pojo.product.ProductExample;
import com.erp4j.ssm.service.process.ProcessService;
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
}
