package com.erp4j.ssm.service.customer;

import com.erp4j.ssm.pojo.custom.Custom;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 23:25
 * @Description:
 */

public interface CustomService {

    List<Custom> queryCustom(int page, int rows);

    int queryTotal();

    boolean insertCustom(Custom custom);
}
