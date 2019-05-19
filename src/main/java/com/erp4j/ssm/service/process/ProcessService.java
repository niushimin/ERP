package com.erp4j.ssm.service.process;

import com.erp4j.ssm.pojo.process.Process;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 15:04
 * @Description:
 */

public interface ProcessService {

    Process queryProcessById(String processId);

    List<Process> queryProcess();
}
