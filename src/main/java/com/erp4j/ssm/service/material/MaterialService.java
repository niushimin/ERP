package com.erp4j.ssm.service.material;

import com.erp4j.ssm.pojo.Material;
import com.erp4j.ssm.pojo.device.EUDataGridResult;

import java.util.List;

public interface MaterialService {
    EUDataGridResult getList(Integer page, Integer rows, Material material);

    boolean updateNote(Material material);

    boolean deleteMultiCustom(List<String> ids);

    boolean insert(Material material);

    boolean update(Material material);

    EUDataGridResult searchMaterialByMaterialId(Integer page, Integer rows, String materialId);

    EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows, String materialType);

    Material get(String materialId);

    List<Material> find();
}
