package com.erp4j.ssm.service.task.impl;

import com.erp4j.ssm.mapper.task.TaskMapper;
import com.erp4j.ssm.pojo.task.Task;
import com.erp4j.ssm.pojo.task.TaskExample;
import com.erp4j.ssm.service.task.TaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 21:27
 * @Description:
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> queryTask(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Task> tasks = taskMapper.selectByExample(new TaskExample());
        return tasks;
    }

    @Override
    public int queryTotal() {
        int total = (int) taskMapper.countByExample(new TaskExample());
        return total;
    }

    @Override
    public boolean insertTask(Task task) {
        int result = taskMapper.insertSelective(task);
        return result == 1;
    }

    @Override
    public boolean updateTask(Task task) {
        int result = taskMapper.updateByPrimaryKeySelective(task);
        return result == 1;
    }

    @Override
    public boolean deleteMultiTask(List<String> ids) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdIn(ids);
        int result = taskMapper.deleteByExample(taskExample);
        return result == ids.size();
    }

    @Override
    public List<Task> queryTaskById(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdLike("%" + searchValue + "%");
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        return tasks;
    }

    @Override
    public int queryTotalById(String searchValue) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdLike("%" + searchValue + "%");
        int total = (int) taskMapper.countByExample(taskExample);
        return total;
    }

    @Override
    public List<Task> queryTaskByWork(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andWorkIdLike("%" + searchValue + "%");
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        return tasks;
    }

    @Override
    public int queryTotalByWork(String searchValue) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andWorkIdLike("%" + searchValue + "%");
        int total = (int) taskMapper.countByExample(taskExample);
        return total;
    }

    @Override
    public List<Task> queryTaskByManufacture(String searchValue, int page, int rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andManufactureSnLike("%" + searchValue + "%");
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        return tasks;
    }

    @Override
    public int queryTotalByManufacture(String searchValue) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andManufactureSnLike("%" + searchValue + "%");
        int total = (int) taskMapper.countByExample(taskExample);
        return total;
    }
}
