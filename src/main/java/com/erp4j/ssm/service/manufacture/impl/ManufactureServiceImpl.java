package com.erp4j.ssm.service.manufacture.impl;

import com.erp4j.ssm.mapper.manufacture.ManufactureMapper;
import com.erp4j.ssm.pojo.manufacture.Manufacture;
import com.erp4j.ssm.pojo.manufacture.ManufactureExample;
import com.erp4j.ssm.pojo.manufacture.ManufactureVo;
import com.erp4j.ssm.service.manufacture.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 14:59
 * @Description:
 */

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<Manufacture> queryManufacture(int page, int rows) {
        List<Manufacture> manufactures = manufactureMapper.queryManufacture();
        return manufactures;
    }

    @Override
    public int queryTotal() {
        int total = (int) manufactureMapper.countByExample(new ManufactureExample());
        return total;
    }

    @Override
    public boolean insertManufacture(ManufactureVo manufactureVo) {
        int result = manufactureMapper.insertManufacture(manufactureVo);
        return result == 1;
    }

    @Override
    public boolean updateManufacture(ManufactureVo manufactureVo) {
        int result = manufactureMapper.updateManufacture(manufactureVo);
        return result == 1;
    }

    @Override
    public boolean deleteMultiManufacture(List<String> ids) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andManufactureSnIn(ids);
        int result = manufactureMapper.deleteByExample(manufactureExample);
        return result == ids.size();
    }

    @Override
    public List<Manufacture> queryManufactureById(String searchValue, int page, int rows) {
        List<Manufacture> manufactures = manufactureMapper.queryManufactureById(searchValue);
        return manufactures;
    }

    @Override
    public int queryTotalById(String searchValue) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andManufactureSnLike("%" + searchValue + "%");
        int total = (int) manufactureMapper.countByExample(manufactureExample);
        return total;
    }

    @Override
    public List<Manufacture> queryManufactureByOrderId(String searchValue, int page, int rows) {
        List<Manufacture> manufactures = manufactureMapper.queryManufactureByOrderId(searchValue);
        return manufactures;
    }

    @Override
    public int queryTotalByOrderId(String searchValue) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andOrderIdLike("%" + searchValue + "%");
        int total = (int) manufactureMapper.countByExample(manufactureExample);
        return total;
    }

    @Override
    public List<Manufacture> queryManufactureByTechnologyName(String searchValue, int page, int rows) {
        List<Manufacture> manufactures = manufactureMapper.queryManufactureByTechnologyName(searchValue);
        return manufactures;
    }

    @Override
    public int queryTotalByTechnologyName(String searchValue) {
        int total = manufactureMapper.queryTotalByTechnologyName(searchValue);
        return total;
    }
}
