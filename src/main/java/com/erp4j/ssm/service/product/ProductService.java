package com.erp4j.ssm.service.product;

import com.erp4j.ssm.pojo.product.Product;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 15:20
 * @Description:
 */

public interface ProductService {

    List<Product> queryProduct(int page, int rows);

    int queryTotal();
}
