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
}
