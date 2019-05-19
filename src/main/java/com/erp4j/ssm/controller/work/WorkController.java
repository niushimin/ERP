package com.erp4j.ssm.controller.work;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkVo;
import com.erp4j.ssm.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 20:25
 * @Description:
 */

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping("/find")
    public String find() {
        return "work_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map list(int page, int rows) {
        List<Work> list = workService.queryWork(page, rows);
        int total = workService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增作业信息权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增作业信息页面
    @RequestMapping("/add")
    public String add() {
        return "work_add";
    }

    // 保存作业信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(WorkVo workVo) {
        boolean flag = workService.insertWork(workVo);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改作业信息权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改作业信息页面
    @RequestMapping("/edit")
    public String edit() {
        return "work_edit";
    }

    // 保存作业信息
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(WorkVo workVo) {
        boolean flag = workService.updateWork(workVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除作业信息权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    // 批量删除作业信息
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = workService.deleteMultiWork(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据作业Id查询订单信息
    @ResponseBody
    @RequestMapping("/search_work_by_workId")
    public Map<String, Object> search_work_by_workId(String searchValue, int page, int rows) {
        List<Work> list = workService.queryWorkById(searchValue, page, rows);
        int total = workService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据产品名称查询作业信息
    @ResponseBody
    @RequestMapping("/search_work_by_workProduct")
    public Map<String, Object> search_work_by_workProduct(String searchValue, int page, int rows) {
        List<Work> list = workService.queryWorkByProduct(searchValue, page, rows);
        int total = workService.queryTotalByProduct(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据设备名称查询作业信息
    @ResponseBody
    @RequestMapping("/search_work_by_workDevice")
    public Map<String, Object> search_work_by_workDevice(String searchValue, int page, int rows) {
        List<Work> list = workService.queryWorkByDevice(searchValue, page, rows);
        int total = workService.queryTotalDevice(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据工序查询作业信息
    @ResponseBody
    @RequestMapping("/search_work_by_workProcess")
    public Map<String, Object> search_work_by_workProcess(String searchValue, int page, int rows) {
        List<Work> list = workService.queryWorkByProcess(searchValue, page, rows);
        int total = workService.queryTotalProcess(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
