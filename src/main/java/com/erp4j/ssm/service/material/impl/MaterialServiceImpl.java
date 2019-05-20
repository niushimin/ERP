package com.erp4j.ssm.service.material.impl;

import com.erp4j.ssm.mapper.material.MaterialMapper;
import com.erp4j.ssm.pojo.Material;
import com.erp4j.ssm.pojo.MaterialExample;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows, Material material) {
        //查询列表
        MaterialExample example = new MaterialExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<Material> list = materialMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public boolean updateNote(Material material) {
        int i = materialMapper.updateNote(material);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdIn(ids);
        int i = materialMapper.deleteByExample(materialExample);
        return i == ids.size();
    }

    @Override
    public boolean insert(Material material) {
        int i = materialMapper.insertSelective(material);
        return i == 1;
    }

    @Override
    public boolean update(Material material) {
        int i = materialMapper.updateByPrimaryKey(material);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchMaterialByMaterialId(Integer page, Integer rows, String materialId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Material> list = materialMapper.searchMaterialByMaterialId(materialId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows, String materialType) {
        PageHelper.startPage(page,rows);
        List<Material> list = materialMapper.searchMaterialByMaterialType(materialType);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public Material get(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public List<Material> find() {
        List<Material> list = materialMapper.listType();
        return list;
    }


}
