package com.erp4j.ssm.service.department;

import com.erp4j.ssm.pojo.department.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 23:47
 * @Description:
 */
public interface DepartmentService {

    List<Department> queryDepartment(int page, int rows);

    int queryTotal();

    boolean insertDepartment(Department department);

    boolean updateDepartment(Department department);

    boolean deleteMultiDepartment(List<String> ids);

    List<Department> queryDepartmentById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Department> queryDepartmentByName(String searchValue, int page, int rows);

    int queryTotalByName(String searchValue);

    List<Department> searchDepartemtAll();
}
