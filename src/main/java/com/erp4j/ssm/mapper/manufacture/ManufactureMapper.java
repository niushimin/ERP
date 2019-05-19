package com.erp4j.ssm.mapper.manufacture;

import com.erp4j.ssm.pojo.manufacture.Manufacture;
import com.erp4j.ssm.pojo.manufacture.ManufactureExample;
import java.util.List;

import com.erp4j.ssm.pojo.manufacture.ManufactureVo;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> queryManufacture();

    int insertManufacture(ManufactureVo manufactureVo);

    int updateManufacture(ManufactureVo manufactureVo);

    List<Manufacture> queryManufactureById(String searchValue);

    List<Manufacture> queryManufactureByOrderId(String searchValue);

    List<Manufacture> queryManufactureByTechnologyName(String searchValue);

    int queryTotalByTechnologyName(String searchValue);
}