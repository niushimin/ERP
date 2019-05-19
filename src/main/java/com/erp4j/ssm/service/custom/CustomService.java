package com.erp4j.ssm.service.custom;

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

    boolean deleteMultiCustom(List<String> ids);

    boolean updateCustom(Custom custom);

    List<Custom> queryCustom();

    Custom queryCustomById(String customId);

    List<Custom> queryCustomById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Custom> queryCustomByName(String searchValue, int page, int rows);

    int queryTotalByName(String searchValue);
}
