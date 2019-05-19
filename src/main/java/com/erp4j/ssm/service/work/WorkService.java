package com.erp4j.ssm.service.work;

import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkVo;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 20:26
 * @Description:
 */
public interface WorkService {

    List<Work> queryWork(int page, int rows);

    int queryTotal();

    boolean deleteMultiWork(List<String> ids);

    boolean insertWork(WorkVo workVo);

    boolean updateWork(WorkVo workVo);

    List<Work> queryWorkById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Work> queryWorkByProduct(String searchValue, int page, int rows);

    int queryTotalByProduct(String searchValue);

    List<Work> queryWorkByDevice(String searchValue, int page, int rows);

    int queryTotalDevice(String searchValue);

    List<Work> queryWorkByProcess(String searchValue, int page, int rows);

    int queryTotalProcess(String searchValue);
}
