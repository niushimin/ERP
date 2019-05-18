package com.erp4j.ssm.controller.quality.monitor;

<<<<<<< HEAD:src/main/java/com/erp4j/ssm/controller/quality/monitor/EmployeeController.java
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.Employee;
=======
import com.erp4j.ssm.pojo.ResponseVo;
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.product.Product;
>>>>>>> af593ec04339fac75599caff3861ae2b1ef12acc:src/main/java/com/erp4j/ssm/controller/quality/monitor/UnqulifyController.java
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

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



}
