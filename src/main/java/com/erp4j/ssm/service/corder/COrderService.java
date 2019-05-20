package com.erp4j.ssm.service.corder;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.corder.COrderVo;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:46
 * @Description:
 */

public interface COrderService {

    List<COrder> queryCOrder(int page, int rows);

    int queryTotal();

    boolean insertCOrder(COrderVo queryVo);

    boolean deleteMultiCOrder(List<String> ids);

    boolean updateCOrder(COrderVo queryVo);

    List<COrder> queryCOrderById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<COrder> queryCOrderByCustom(String searchValue, int page, int rows);

    int queryTotalByCustom(String searchValue);

    List<COrder> queryCOrderByProduct(String searchValue, int page, int rows);

    int queryTotalByProduct(String searchValue);

    COrder queryCOrderById(String cOrderId);

    List<COrder> queryCOrder();
}
