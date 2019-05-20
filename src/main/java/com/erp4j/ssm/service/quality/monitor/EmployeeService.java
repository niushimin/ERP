package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.QueryParameters;
import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;
import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;
import com.erp4j.ssm.pojo.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ResponseVo selectEmployeeAll(int page, int rows);

    ResponseStatus insertEmployee(Employee employee);

    ResponseStatus updateEmployee(Employee employee);

    ResponseStatus deleteBatchEmployee(String[] ids);

    ResponseVo searchEmployeeByEmployeeId(QueryParameters queryParameters);

    ResponseVo searchEmployeeByEmployeeName(QueryParameters queryParameters);

    ResponseVo searchEmployeeByDepartmentName(QueryParameters queryParameters);
}
