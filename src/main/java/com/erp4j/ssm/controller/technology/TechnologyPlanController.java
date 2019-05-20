package com.erp4j.ssm.controller.technology;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.technology.Technology;
import com.erp4j.ssm.pojo.technology.TechnologyPlan;
import com.erp4j.ssm.pojo.technology.TechnologyRequirement;
import com.erp4j.ssm.service.technology.TechnologyPlanService;
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
 * @Date: 2019/5/20 14:00
 * @Description:
 */

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    // 从主页查看工艺计划列表信息
    @RequestMapping("/find")
    public String find() {
        return "technologyPlan_list";
    }

    // 返回工艺计划列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<TechnologyPlan> list = technologyPlanService.queryTechnologyPlan(page, rows);
        int total = technologyPlanService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增工艺计划权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增公益计划页面
    @RequestMapping("/add")
    public String add() {
        return "technologyPlan_add";
    }

    // 保存信息到数据库中
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(TechnologyPlan technologyPlan) {
        boolean flag = technologyPlanService.insertTechnologyPlan(technologyPlan);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改工艺计划权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改工艺计划页面
    @RequestMapping("/edit")
    public String edit() {
        return "technologyPlan_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(TechnologyPlan technologyPlan) {
        boolean flag = technologyPlanService.updateTechnologyPlan(technologyPlan);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除工艺计划权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除工艺计划
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = technologyPlanService.deleteMultiTechnologyPlan(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据工艺计划Id获取工艺计划信息
    @ResponseBody
    @RequestMapping("/get/{technologyPlanId}")
    public TechnologyPlan get(@PathVariable("technologyPlanId") String technologyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanService.queryTechnologyPlanById(technologyPlanId);
        return technologyPlan;
    }

    // 根据工艺计划Id获取工艺计划信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<TechnologyPlan> get_data() {
        List<TechnologyPlan> list = technologyPlanService.queryTechnologyPlan();
        return list;
    }

    // 根据工艺计划Id查询工艺计划
    @ResponseBody
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    public Map<String, Object> search_technologyPlan_by_technologyPlanId(String searchValue, int page, int rows) {
        List<TechnologyPlan> list = technologyPlanService.queryTechnologyPlanById(searchValue, page, rows);
        int total = technologyPlanService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据工艺计划查询工艺计划
    @ResponseBody
    @RequestMapping("/search_technologyPlan_by_technologyName")
    public Map<String, Object> search_technologyPlan_by_technologyName(String searchValue, int page, int rows) {
        List<TechnologyPlan> list = technologyPlanService.queryTechnologyPlanByTechnologyName(searchValue, page, rows);
        int total = technologyPlanService.queryTotalByTechnologyName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
