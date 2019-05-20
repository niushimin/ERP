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

    List<Process> queryProcess(int page, int rows);

    int queryTotal();

    boolean insertProcess(Process process);

    boolean updateProcess(Process process);

    boolean deleteMultiProcess(List<String> ids);

    List<Process> queryProcessById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Process> queryProcessByTechnologyPlanId(String searchValue, int page, int rows);

    int queryTotalByTechnologyPlanId(String searchValue);
}
