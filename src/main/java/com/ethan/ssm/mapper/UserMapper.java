package com.ethan.ssm.mapper;

import com.ethan.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Ethan New
 * @Date: 2019/5/15 20:28
 * @Description:
 */
public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);
}
