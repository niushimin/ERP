package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.*;
import com.erp4j.ssm.pojo.Employee;


import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.service.quality.monitor.EmployeeService;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

    @Autowired
    EmployeeService employeeService;

    /*员工管理*/
    @RequestMapping("/find")
    public String findEmployee(){
        return "employee_list";
    }
    /*返回员工列表*/
    @ResponseBody
    @RequestMapping("/list")
    public ResponseVo selectEmployeeAll(int page, int rows){
        ResponseVo responseVo = employeeService.selectEmployeeAll(page,rows);
        return responseVo;
    }

    /*返回不合格品列表*/
    @ResponseBody
    @RequestMapping("/unqualify/list")
    public ResponseVo unqualifyList(int page, int rows){

        ResponseVo responseVo = unqulifyFindService.getResponseVo(page,rows);

        return responseVo;
    }

    /*返回申请人详细信息*/
    @ResponseBody
    @RequestMapping("/get/{empId}")
    public EmployeeForm selectEmployeeById(@PathVariable("empId") String empId){
        EmployeeForm employeeForm = unqulifyFindService.selectEmployeeById(empId);
        return employeeForm;
    }
    /*返回所有申请人信息*/
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Employee> selectEmployAll(){
        List<Employee> employees = unqulifyFindService.selectEmployAll();
        return employees;
    }
    /*修改申请人验证*/
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String,String> editEmployeeJudge(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg",null);
        return hashMap;
    }
    /*修改申请人*/
    @ResponseBody
    @RequestMapping("/update_all")
    public ResponseStatus updateEmployeeAll(Employee employee){
        ResponseStatus responseStatus = null;
        if(unqulifyFindService.updateEmployeeAll(employee)){
            responseStatus = unqulifyFindService.getResponseStatus("OK","200");
        }else{
            responseStatus = unqulifyFindService.getResponseStatus("修改失败","400");
        }

        return responseStatus;
    }
    /*新增申请人验证*/
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> addJudgeEmployee(){
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    /*删除申请人验证*/
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> deleteJudgeEmployee(){
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    /*新增申请人*/
    @RequestMapping("/add")
    public String addEmployee(){
        return "employee_add";
    }
    /*修改申请人*/
    @RequestMapping("/edit")
    public String editEmployee(){
        return "employee_edit";
    }
    /*提交删除申请人*/
    @ResponseBody
    @RequestMapping("/delete_batch")
    public ResponseStatus deleteBatchEmployee(String[] ids){
        ResponseStatus responseStatus = employeeService.deleteBatchEmployee(ids);
        return responseStatus;
    }
    /*提交新增申请人*/
    @ResponseBody
    @RequestMapping("/insert")
    public ResponseStatus insertEmployee(Employee employee){
        ResponseStatus responseStatus = employeeService.insertEmployee(employee);
        return responseStatus;
    }

//    搜索申请人通过员工编号
    @ResponseBody
    @RequestMapping("/search_employee_by_employeeId")
    public ResponseVo searchEmployeeByEmployeeId(QueryParameters queryParameters){
        ResponseVo responseVo = employeeService.searchEmployeeByEmployeeId(queryParameters);
        return responseVo;
    }
    /*搜索申请人通过员工名称*/
    @ResponseBody
    @RequestMapping("/search_employee_by_employeeName")
    public ResponseVo searchEmployeeByEmployeeName(QueryParameters queryParameters){
        ResponseVo responseVo = employeeService.searchEmployeeByEmployeeName(queryParameters);
        return responseVo;
    }
    /*搜索申请人通过部门名称*/
    @ResponseBody
    @RequestMapping("/search_employee_by_departmentName")
    public ResponseVo searchEmployeeByDepartmentName(QueryParameters queryParameters){
        ResponseVo responseVo = employeeService.searchEmployeeByDepartmentName(queryParameters);
        return responseVo;
    }
}
