package com.erp4j.ssm.service.task;

import com.erp4j.ssm.pojo.task.Task;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 21:27
 * @Description:
 */

public interface TaskService {

    List<Task> queryTask(int page, int rows);

    int queryTotal();

    boolean insertTask(Task task);

    boolean updateTask(Task task);

    boolean deleteMultiTask(List<String> ids);

    List<Task> queryTaskById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Task> queryTaskByWork(String searchValue, int page, int rows);

    int queryTotalByWork(String searchValue);

    List<Task> queryTaskByManufacture(String searchValue, int page, int rows);

    int queryTotalByManufacture(String searchValue);
}
