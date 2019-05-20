package com.erp4j.ssm.controller.technology;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.technology.Technology;
import com.erp4j.ssm.service.technology.TechnologyService;
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
 * @Date: 2019/5/19 18:05
 * @Description:
 */

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    // 从主页查看工艺列表信息
    @RequestMapping("/find")
    public String find() {
        return "technology_list";
    }

    // 返回工艺列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<Technology> list = technologyService.queryTechnology(page, rows);
        int total = technologyService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增工艺信息权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增工艺信息页面
    @RequestMapping("/add")
    public String add() {
        return "technology_add";
    }

    // 保存信息到数据库中
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Technology technology) {
        boolean flag = technologyService.insertTechnology(technology);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改工艺信息权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改工艺信息页面
    @RequestMapping("/edit")
    public String edit() {
        return "technology_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Technology technology) {
        boolean flag = technologyService.updateTechnology(technology);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除工艺信息权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除工艺信息
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = technologyService.deleteMultiTechnology(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据工艺Id获取工艺信息
    @ResponseBody
    @RequestMapping("/get/{technologyId}")
    public Technology get(@PathVariable("technologyId") String technologyId) {
        Technology technology = technologyService.queryTechnologyById(technologyId);
        return technology;
    }

    // 获取所有的工艺信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Technology> get_data() {
        List<Technology> list = technologyService.queryTechnology();
        return list;
    }

    // 根据客户Id查询客户信息
    @ResponseBody
    @RequestMapping("/search_technology_by_technologyId")
    public Map<String, Object> search_technology_by_technologyId(String searchValue, int page, int rows) {
        List<Technology> list = technologyService.queryTechnologyById(searchValue, page, rows);
        int total = technologyService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据客户名称查询客户信息
    @ResponseBody
    @RequestMapping("/search_technology_by_technologyName")
    public Map<String, Object> search_technology_by_technologyName(String searchValue, int page, int rows) {
        List<Technology> list = technologyService.queryTechnologyByName(searchValue, page, rows);
        int total = technologyService.queryTotalByName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
