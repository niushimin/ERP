package com.erp4j.ssm.service.corder.impl;

import com.erp4j.ssm.mapper.corder.COrderMapper;
import com.erp4j.ssm.pojo.QueryVo;
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

    @Override
    public boolean insertCOrder(QueryVo queryVo) {
        int total =  orderMapper.insertCOrder(queryVo);
        return total == 1;
    }

    @Override
    public boolean deleteMultiCOrder(List<String> ids) {
        COrderExample cOrderExample = new COrderExample();
        COrderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andOrderIdIn(ids);
        int result = orderMapper.deleteByExample(cOrderExample);
        return result == ids.size();
    }

    @Override
    public boolean updateCOrder(QueryVo queryVo) {
        int result = orderMapper.updateCorder(queryVo);
        return result == 1;
    }

    @Override
    public List<COrder> queryCOrderById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> cOrders = orderMapper.queryCOrderById(searchValue);
        return cOrders;
    }

    @Override
    public int queryTotalById(String searchValue) {
        COrderExample cOrderExample = new COrderExample();
        COrderExample.Criteria criteria = cOrderExample.createCriteria();
        criteria.andCustomIdLike("%" + searchValue + "%");
        int total = (int) orderMapper.countByExample(cOrderExample);
        return total;
    }

    @Override
    public List<COrder> queryCOrderByCustom(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> corders = orderMapper.queryCorderByCustom(searchValue);
        return corders;
    }

    @Override
    public int queryTotalByCustom(String searchValue) {
        int total = orderMapper.queryTotalByCustom(searchValue);
        return total;
    }

    @Override
    public List<COrder> queryCOrderByProduct(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<COrder> corders = orderMapper.queryCorderByProduct(searchValue);
        return corders;
    }

    @Override
    public int queryTotalByProduct(String searchValue) {
        int total = orderMapper.queryTotalByProduct(searchValue);
        return total;
    }

    @Override
    public COrder queryCOrderById(String cOrderId) {
        COrder cOrder = orderMapper.querySingleById(cOrderId);
        return cOrder;
    }

    @Override
    public List<COrder> queryCOrder() {
        List<COrder> corders = orderMapper.queryCorder();
        return corders;
    }

}
