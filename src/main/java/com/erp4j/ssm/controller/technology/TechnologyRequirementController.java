package com.erp4j.ssm.controller.technology;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.technology.TechnologyRequirement;
import com.erp4j.ssm.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 11:22
 * @Description:
 */

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;

    // 从主页查看工艺要求列表信息
    @RequestMapping("/find")
    public String find() {
        return "technologyRequirement_list";
    }

    // 返回工艺要求列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<TechnologyRequirement> list = technologyRequirementService.queryTechnologyRequirement(page, rows);
        int total = technologyRequirementService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增工艺要求权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增工艺要求页面
    @RequestMapping("/add")
    public String add() {
        return "technologyRequirement_add";
    }

    // 保存信息到数据库中
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(TechnologyRequirement technologyRequirement) {
        boolean flag = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改工艺要求权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改工艺要求页面
    @RequestMapping("/edit")
    public String edit() {
        return "technologyRequirement_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(TechnologyRequirement technologyRequirement) {
        boolean flag = technologyRequirementService.updateTechnologyRequirement(technologyRequirement);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除工艺要求权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除工艺要求
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = technologyRequirementService.deleteMultiTechnologyRequirement(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据工艺要求Id查询工艺要求
    @ResponseBody
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    public Map<String, Object> search_technologyRequirement_by_technologyRequirementId(String searchValue, int page, int rows) {
        List<TechnologyRequirement> list = technologyRequirementService.queryTechnologyRequirementById(searchValue, page, rows);
        int total = technologyRequirementService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据工艺要求查询工艺要求
    @ResponseBody
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    public Map<String, Object> search_technologyRequirement_by_technologyName(String searchValue, int page, int rows) {
        List<TechnologyRequirement> list = technologyRequirementService.queryTechnologyRequirementByTechnologyName(searchValue, page, rows);
        int total = technologyRequirementService.queryTotalByTechnologyName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
