package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.*;
import com.erp4j.ssm.pojo.Employee;
import com.erp4j.ssm.pojo.UnqualifyApply;

import java.util.List;
import java.util.Map;

import com.erp4j.ssm.actionform.quality.monitor.EmployeeForm;
import com.erp4j.ssm.pojo.product.Product;


public interface UnqulifyFindService {

    ResponseVo getResponseVo(int page, int rows);

    Product selectProductById(String productId);

    EmployeeForm selectEmployeeById(String empId);

    List<Product> selectProductAll();

    List<Employee> selectEmployAll();

    void deleteUnqulifyById(String[] ids);

    void insertUnqulify(UnqualifyApply unqualifyApply);

    ResponseStatus getResponseStatus();

    void unqulifyUpdateAll(UnqualifyApply unqualifyApply);

    ResponseVo searchUnqualifyByUnqualifyId(QueryParameters queryParameters);

    ResponseVo searchUnqualifyByProductName(QueryParameters queryParameters);
}
