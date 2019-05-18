package com.erp4j.ssm.controller.quality.monitor;

import com.erp4j.ssm.pojo.Product;
import com.erp4j.ssm.service.quality.monitor.UnqulifyFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    UnqulifyFindService unqulifyFindService;

    /*返回产品详细信息*/
    @ResponseBody
    @RequestMapping("/get/{productId}")
    public Product selectProductById(@PathVariable("productId") String productId){
        Product product = unqulifyFindService.selectProductById(productId);
        return product;
    }
    /*返回所有商品信息*/
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Product> selectProductAll(){
        List<Product> products = unqulifyFindService.selectProductAll();
        return products;
    }
}
