package com.erp4j.ssm.service.material.impl;

import com.erp4j.ssm.mapper.material.MaterialReceiveMapper;
import com.erp4j.ssm.pojo.MaterialReceive;
import com.erp4j.ssm.pojo.MaterialReceiveExample;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialReceiveVo;
import com.erp4j.ssm.service.material.MaterialReceiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public EUDataGridResult getList(Integer page, Integer rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialReceiveVo> list = materialReceiveMapper.find();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialReceiveVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public boolean updateNote(MaterialReceiveVo materialReceiveVo) {
        int i = materialReceiveMapper.updateNote(materialReceiveVo);
        return i == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
        for (String id : ids) {
            materialReceiveMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public boolean insert(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.insertSelective(materialReceive);
        return i == 1;
    }

    @Override
    public boolean update(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
        return i == 1;
    }

    @Override
    public EUDataGridResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String receiveId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialReceiveVo> list = materialReceiveMapper.searchMaterialReceiveByReceiveId(receiveId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialReceiveVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult searchMaterialReceiveByMaterialId(Integer page, Integer rows, String materialId) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<MaterialReceiveVo> list = materialReceiveMapper.searchMaterialReceiveByMaterialId(materialId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<MaterialReceiveVo> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
