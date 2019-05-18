package com.erp4j.ssm.service.corder.impl;

import com.erp4j.ssm.mapper.corder.COrderMapper;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.corder.COrderExample;
import com.erp4j.ssm.service.corder.COrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:45
 * @Description:
 */

@Service
public class COrderServiceImpl implements COrderService {

    @Autowired
    COrderMapper orderMapper;

    @Override
    public List<COrder> queryCOrder(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> corders = orderMapper.queryCorder();
        return corders;
    }

    @Override
    public int queryTotal() {
        int total = (int) orderMapper.countByExample(new COrderExample());
        return total;
    }
}
