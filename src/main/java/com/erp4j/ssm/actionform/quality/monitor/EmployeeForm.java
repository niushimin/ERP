package com.erp4j.ssm.actionform.quality.monitor;

import com.erp4j.ssm.pojo.Department;
import com.erp4j.ssm.pojo.Employee;

public class EmployeeForm extends Employee {
    Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
