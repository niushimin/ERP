package com.erp4j.ssm.service.manufacture;

import com.erp4j.ssm.pojo.manufacture.Manufacture;
import com.erp4j.ssm.pojo.manufacture.ManufactureVo;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 14:58
 * @Description:
 */
public interface ManufactureService {

    List<Manufacture> queryManufacture(int page, int rows);

    int queryTotal();

    boolean insertManufacture(ManufactureVo manufactureVo);

    boolean updateManufacture(ManufactureVo manufactureVo);

    boolean deleteMultiManufacture(List<String> ids);

    List<Manufacture> queryManufactureById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Manufacture> queryManufactureByOrderId(String searchValue, int page, int rows);

    int queryTotalByOrderId(String searchValue);

    List<Manufacture> queryManufactureByTechnologyName(String searchValue, int page, int rows);

    int queryTotalByTechnologyName(String searchValue);

    Manufacture queryManufactureById(String manufactureSn);

    List<Manufacture> queryManufacture();
}
