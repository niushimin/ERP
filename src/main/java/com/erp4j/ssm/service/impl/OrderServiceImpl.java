package com.erp4j.ssm.service.impl;

import com.erp4j.ssm.mapper.COrderMapper;
import com.erp4j.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:45
 * @Description:
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    COrderMapper orderMapper;

    @Override
    public void find() {

    }
}
