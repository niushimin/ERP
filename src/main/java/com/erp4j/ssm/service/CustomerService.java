package com.erp4j.ssm.service;

import com.erp4j.ssm.pojo.Custom;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 23:25
 * @Description:
 */

public interface CustomerService {

    int findTotal();

    List<Custom> findRows();
}
