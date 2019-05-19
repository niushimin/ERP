package com.erp4j.ssm.mapper.corder;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.corder.COrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface COrderMapper {

    // 逆向工程生成的接口
    long countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);


    // 自己写的接口
    List<COrder> queryCorder();

    int insertCOrder(QueryVo queryVo);

    int updateCorder(QueryVo queryVo);

    List<COrder> queryCOrderById(String searchValue);

    List<COrder> queryCorderByCustom(String searchValue);

    int queryTotalByCustom(String searchValue);

    List<COrder> queryCorderByProduct(String searchValue);

    int queryTotalByProduct(String searchValue);

    COrder querySingleById(String cOrderId);

    List<String> queryCOrderId();
}