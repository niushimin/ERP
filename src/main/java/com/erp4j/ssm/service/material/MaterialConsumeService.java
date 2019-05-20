package com.erp4j.ssm.service.material;

import com.erp4j.ssm.pojo.MaterialConsume;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialConsumeVo;

import java.util.List;

public interface MaterialConsumeService {
    EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVo materialConsumeVo);

    boolean updateNote(MaterialConsumeVo materialConsumeVo);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(MaterialConsume materialConsume);

    boolean update(MaterialConsume materialConsume);

    EUDataGridResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String consumeId);

    EUDataGridResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String materialId);

    EUDataGridResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String workId);
}
