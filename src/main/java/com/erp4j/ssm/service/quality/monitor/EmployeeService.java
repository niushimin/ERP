package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.actionform.quality.monitor.ResponseVo;

public interface EmployeeService {
    ResponseVo selectEmployeeAll(int page, int rows);
}
