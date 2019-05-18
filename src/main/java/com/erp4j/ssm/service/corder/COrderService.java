package com.erp4j.ssm.service.corder;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:46
 * @Description:
 */

public interface COrderService {

    List<COrder> queryCOrder(int page, int rows);

    int queryTotal();

    boolean insertCOrder(QueryVo queryVo);

    boolean deleteMultiCOrder(List<String> ids);

    boolean updateCOrder(QueryVo queryVo);
}
