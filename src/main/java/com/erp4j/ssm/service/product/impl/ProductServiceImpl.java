package com.erp4j.ssm.service.product.impl;

import com.erp4j.ssm.mapper.product.ProductMapper;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.custom.CustomExample;
import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.pojo.product.ProductExample;
import com.erp4j.ssm.service.product.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 15:20
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> queryProduct(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.selectByExample(new ProductExample());
        return products;
    }

    @Override
    public int queryTotal() {
        int total = (int) productMapper.countByExample(new ProductExample());
        return total;
    }

    @Override
    public boolean insertProduct(Product product) {
        int result = productMapper.insertSelective(product);
        return result == 1;
    }

    @Override
    public boolean updateProduct(Product product) {
        int result = productMapper.updateByPrimaryKeySelective(product);
        return result == 1;
    }

    @Override
    public boolean deleteMultiProduct(List<String> ids) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdIn(ids);
        int result = productMapper.deleteByExample(productExample);
        return result == ids.size();
    }

    @Override
    public Product queryProductById(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public List<Product> queryProduct() {
        List<Product> products = productMapper.selectByExample(new ProductExample());
        return products;
    }

    @Override
    public List<Product> queryProductById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdLike("%" + searchValue + "%");
        List<Product> list = productMapper.selectByExample(productExample);
        return list;
    }

    @Override
    public int queryTotalById(String searchValue) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdLike("%" + searchValue + "%");
        int total = (int) productMapper.countByExample(productExample);
        return total;
    }

    @Override
    public List<Product> queryProductByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" + searchValue + "%");
        List<Product> list = productMapper.selectByExample(productExample);
        return list;
    }

    @Override
    public int queryTotalByName(String searchValue) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" + searchValue + "%");
        int total = (int) productMapper.countByExample(productExample);
        return total;
    }

    @Override
    public List<Product> queryProductByType(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductTypeLike("%" + searchValue + "%");
        List<Product> list = productMapper.selectByExample(productExample);
        return list;
    }

    @Override
    public int queryTotalByType(String searchValue) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductTypeLike("%" + searchValue + "%");
        int total = (int) productMapper.countByExample(productExample);
        return total;
    }
}
