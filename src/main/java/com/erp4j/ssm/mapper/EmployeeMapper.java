package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.Employee;
import com.erp4j.ssm.pojo.EmployeeExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /*分隔符-杨盼*/
    ArrayList<Employee> selectEmployeeAll(@Param("empId")String empId,@Param("empName")String empName,@Param("departmentName")String departmentName);

    int selectEmployeeBy(@Param("empId")String empId,@Param("empName")String empName,@Param("departmentName")String departmentName);
    /*分隔符-杨盼*/

}