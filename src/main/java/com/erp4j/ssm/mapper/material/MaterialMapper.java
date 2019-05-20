package com.erp4j.ssm.mapper.material;

import com.erp4j.ssm.pojo.Material;
import com.erp4j.ssm.pojo.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {

    int updateNote(Material material);

    List<Material> searchMaterialByMaterialId(String materialId);

    List<Material> searchMaterialByMaterialType(String materialType);

    List<Material> listType();












    //逆向工程生成
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);



}