package com.erp4j.ssm.controller.process;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.process.Process;
import com.erp4j.ssm.service.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 15:01
 * @Description:
 */

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    // 从主页查看工序列表信息
    @RequestMapping("/find")
    public String find() {
        return "process_list";
    }

    // 返回工序列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<Process> list = processService.queryProcess(page, rows);
        int total = processService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增工序信息权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增工序信息页面
    @RequestMapping("/add")
    public String add() {
        return "process_add";
    }

    // 保存信息到数据库中
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Process process) {
        boolean flag = processService.insertProcess(process);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改工序顾客信息权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改工序信息页面
    @RequestMapping("/edit")
    public String edit() {
        return "process_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Process process) {
        boolean flag = processService.updateProcess(process);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除工序信息权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除工序信息
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = processService.deleteMultiProcess(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据工序Id获取工序信息
    @ResponseBody
    @RequestMapping("/get/{processId}")
    public Process get(@PathVariable String processId) {
        Process process = processService.queryProcessById(processId);
        return process;
    }

    // 获取所有工序信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Process> get_data() {
        List<Process> list = processService.queryProcess();
        return list;
    }

    // 根据工序Id查询工序信息
    @ResponseBody
    @RequestMapping("/search_process_by_processId")
    public Map<String, Object> search_process_by_processId(String searchValue, int page, int rows) {
        List<Process> list = processService.queryProcessById(searchValue, page, rows);
        int total = processService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据工艺计划查询工艺计划
    @ResponseBody
    @RequestMapping("/search_process_by_technologyPlanId")
    public Map<String, Object> search_process_by_technologyPlanId(String searchValue, int page, int rows) {
        List<Process> list = processService.queryProcessByTechnologyPlanId(searchValue, page, rows);
        int total = processService.queryTotalByTechnologyPlanId(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
