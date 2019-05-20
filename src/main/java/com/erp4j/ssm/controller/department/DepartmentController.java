package com.erp4j.ssm.controller.department;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.department.Department;
import com.erp4j.ssm.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 23:45
 * @Description:
 */

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    // 从主页查看部门列表信息
    @RequestMapping("/find")
    public String find() {
        return "department_list";
    }

    // 返回部门列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<Department> list = departmentService.queryDepartment(page, rows);
        int total = departmentService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增部门信息权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增部门信息页面
    @RequestMapping("/add")
    public String add() {
        return "department_add";
    }

    // 保存信息到数据库中
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Department department) {
        boolean flag = departmentService.insertDepartment(department);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改部门信息权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改部门信息页面
    @RequestMapping("/edit")
    public String edit() {
        return "department_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Department department) {
        boolean flag = departmentService.updateDepartment(department);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 删除部门信息权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除部门信息
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = departmentService.deleteMultiDepartment(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改部门职责信息
    @ResponseBody
    @RequestMapping("/update_note")
    public Map<String, Object> update_note(Department department) {
        boolean flag = departmentService.updateDepartment(department);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }


    // 根据部门Id查询部门信息
    @ResponseBody
    @RequestMapping("/search_department_by_departmentId")
    public Map<String, Object> search_department_by_departmentId(String searchValue, int page, int rows) {
        List<Department> list = departmentService.queryDepartmentById(searchValue, page, rows);
        int total = departmentService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据客户名称查询客户信息
    @ResponseBody
    @RequestMapping("/search_department_by_departmentName")
    public Map<String, Object> search_department_by_departmentName(String searchValue, int page, int rows) {
        List<Department> list = departmentService.queryDepartmentByName(searchValue, page, rows);
        int total = departmentService.queryTotalByName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
