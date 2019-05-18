package com.erp4j.ssm.service.work;

import com.erp4j.ssm.pojo.work.Work;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 20:26
 * @Description:
 */
public interface WorkService {

    List<Work> queryWork(int page, int rows);

    int queryTotal();
}
