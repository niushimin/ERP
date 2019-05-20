package com.erp4j.ssm.service.material.impl;

import com.erp4j.ssm.mapper.material.MaterialConsumeMapper;
import com.erp4j.ssm.pojo.MaterialConsume;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialConsumeVo;
import com.erp4j.ssm.service.material.MaterialConsumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVo materialConsumeVo) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialConsumeVo> list = materialConsumeMapper.find(materialConsumeVo);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialConsumeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public boolean updateNote(MaterialConsumeVo materialConsumeVo) {
        int i = materialConsumeMapper.updateNote(materialConsumeVo);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        for (String id : ids) {
            materialConsumeMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public boolean insert(MaterialConsume materialConsume) {
        int i = materialConsumeMapper.insertSelective(materialConsume);
        return i == 1;
    }

    @Override
    public boolean update(MaterialConsume materialConsume) {
        int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String consumeId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialConsumeVo> list = materialConsumeMapper.searchMaterialConsumeByConsumeId(consumeId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialConsumeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String materialId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialConsumeVo> list = materialConsumeMapper.searchMaterialConsumeByMaterialId(materialId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialConsumeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String workId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialConsumeVo> list = materialConsumeMapper.searchMaterialConsumeByWorkId(workId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialConsumeVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
