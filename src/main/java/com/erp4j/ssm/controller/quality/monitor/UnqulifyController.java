package com.erp4j.ssm.controller.quality.monitor;


import com.erp4j.ssm.pojo.Product;
import com.erp4j.ssm.pojo.ResponseVo;
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UnqulifyController {

    @Autowired
    UnqulifyFindService unqulifyFindService;

    /*返回不合格品列表*/
    @ResponseBody
    @RequestMapping("/unqualify/list")
    public ResponseVo unqualifyList(int page, int rows){

        ResponseVo responseVo = unqulifyFindService.getResponseVo(page,rows);

        return responseVo;
    }
    /*返回产品详细信息*/
    @ResponseBody
    @RequestMapping("product/get/{productId}")
    public Product selectProductById(@PathVariable("productId") String productId){
        Product product = unqulifyFindService.selectProductById(productId);
        return product;
    }
    /*返回申请人详细信息*/
    @ResponseBody
    @RequestMapping("employee/get/{empId}")
    public EmployeeForm selectEmployeeById(@PathVariable("empId") String empId){
        EmployeeForm employeeForm = unqulifyFindService.selectEmployeeById(empId);
        return employeeForm;
    }
}
