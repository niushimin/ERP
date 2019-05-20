package com.erp4j.ssm.service.material;

import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialConsumeVo;

public interface MaterialConsumeService {
    EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVo materialConsumeVo);
}
