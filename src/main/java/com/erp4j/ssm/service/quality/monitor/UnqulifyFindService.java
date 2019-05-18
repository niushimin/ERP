package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.pojo.Product;
import com.erp4j.ssm.pojo.ResponseVo;
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;

public interface UnqulifyFindService {

    ResponseVo getResponseVo(int page, int rows);

    Product selectProductById(String productId);

    EmployeeForm selectEmployeeById(String empId);
}
