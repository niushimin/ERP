package com.erp4j.ssm.service.product.impl;

import com.erp4j.ssm.mapper.product.ProductMapper;
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
        PageHelper.offsetPage(page, rows);
        List<Product> products = productMapper.selectByExample(new ProductExample());
        return products;
    }

    @Override
    public int queryTotal() {
        int total = (int) productMapper.countByExample(new ProductExample());
        return total;
    }

    @Override
    public boolean insertCustom(Product product) {
        int result = productMapper.insertSelective(product);
        return result == 1;
    }

    @Override
    public boolean updateCustom(Product product) {
        int result = productMapper.updateByPrimaryKey(product);
        return result == 1;
    }

    @Override
    public boolean deleteMultiCustom(List<String> ids) {
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
}
