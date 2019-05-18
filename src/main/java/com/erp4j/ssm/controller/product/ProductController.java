package com.erp4j.ssm.controller.product;

import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/18 15:19
 * @Description:
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/find")
    public String find() {
        return "product_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map list(int page, int rows) {
        List<Product> list = productService.queryProduct(page, rows);
        int total = productService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
