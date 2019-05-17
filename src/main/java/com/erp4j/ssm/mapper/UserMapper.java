package com.erp4j.ssm.mapper;

import com.erp4j.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:
 * @Date: 2019/5/15 20:28
 * @Description:
 */
public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);
}
