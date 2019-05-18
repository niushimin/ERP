package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.pojo.ResponseVo;
import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.product.Product;

public interface UnqulifyFindService {

    ResponseVo getResponseVo(int page, int rows);

    Product selectProductById(String productId);

    EmployeeForm selectEmployeeById(String empId);
}
