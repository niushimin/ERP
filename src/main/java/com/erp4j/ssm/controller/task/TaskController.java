package com.erp4j.ssm.controller.task;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.task.Task;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 21:29
 * @Description:
 */

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    // 从主页查看生产派工信息
    @RequestMapping("/find")
    public String find() {
        return "task_list";
    }

    // 返回生产派工列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<Task> list = taskService.queryTask(page, rows);
        int total = taskService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增生产派工权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增生产派工页面
    @RequestMapping("/add")
    public String add() {
        return "task_add";
    }

    // 保存生产派工信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Task task) {
        boolean flag = taskService.insertTask(task);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改生产派工权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改生产派工页面
    @RequestMapping("/edit")
    public String edit() {
        return "task_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Task task) {
        boolean flag = taskService.updateTask(task);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除生产派工权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除生产派工
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = taskService.deleteMultiTask(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据生产派工Id查询生产派工信息
    @ResponseBody
    @RequestMapping("/search_task_by_taskId")
    public Map<String, Object> search_task_by_taskId(String searchValue, int page, int rows) {
        List<Task> list = taskService.queryTaskById(searchValue, page, rows);
        int total = taskService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据作业Id查询生产派工信息
    @ResponseBody
    @RequestMapping("/search_task_by_taskWorkId")
    public Map<String, Object> search_task_by_taskWorkId(String searchValue, int page, int rows) {
        List<Task> list = taskService.queryTaskByWork(searchValue, page, rows);
        int total = taskService.queryTotalByWork(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据作业Id查询生产派工信息
    @ResponseBody
    @RequestMapping("/search_task_by_taskManufactureSn")
    public Map<String, Object> search_task_by_taskManufactureSn(String searchValue, int page, int rows) {
        List<Task> list = taskService.queryTaskByManufacture(searchValue, page, rows);
        int total = taskService.queryTotalByManufacture(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
