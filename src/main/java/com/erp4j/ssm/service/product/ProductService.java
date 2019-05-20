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

    boolean insertProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteMultiProduct(List<String> ids);

    Product queryProductById(String productId);

    List<Product> queryProduct();

    List<Product> queryProductById(String searchValue, int page, int rows);

    int queryTotalById(String searchValue);

    List<Product> queryProductByName(String searchValue, int page, int rows);

    int queryTotalByName(String searchValue);

    List<Product> queryProductByType(String searchValue, int page, int rows);

    int queryTotalByType(String searchValue);

}
