package com.erp4j.ssm.service.impl;

import com.erp4j.ssm.mapper.COrderMapper;
import com.erp4j.ssm.pojo.COrder;
import com.erp4j.ssm.pojo.COrderExample;
import com.erp4j.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<COrder> findRows() {
        COrderExample example = new COrderExample();
        List<COrder> cOrders = orderMapper.selectByExample(example);
        return cOrders;
    }

    @Override
    public int findTotal() {
        COrderExample example = new COrderExample();
        int count = (int) orderMapper.countByExample(example);
        return count;
    }
}
