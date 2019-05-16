package com.ethan.ssm;

import com.ethan.ssm.mapper.UserMapper;
import com.ethan.ssm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Ethan New
 * @Date: 2019/5/15 20:49
 * @Description:
 */
@ContextConfiguration("classpath:application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

    /*@Autowired
    UserMapper userMapper;

    @Test
    public void mytest() {
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }*/
}
