package com.erp4j.ssm.service.material;

import com.erp4j.ssm.pojo.MaterialReceive;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialReceiveVo;

import java.util.List;

public interface MaterialReceiveService {
    EUDataGridResult getList(Integer page, Integer rows);

    boolean updateNote(MaterialReceiveVo materialReceiveVo);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(MaterialReceive materialReceive);

    boolean update(MaterialReceive materialReceive);

    EUDataGridResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String receiveId);

    EUDataGridResult searchMaterialReceiveByMaterialId(Integer page, Integer rows, String materialId);
}
