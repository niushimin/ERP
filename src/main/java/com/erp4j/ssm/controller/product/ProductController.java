package com.erp4j.ssm.controller.product;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.custom.Custom;
import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("/add")
    public String add() {
        return "product_add";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(Product product) {
        boolean flag = productService.insertCustom(product);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @RequestMapping("/edit")
    public String edit() {
        return "product_edit";
    }

    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(Product product) {
        boolean flag = productService.updateCustom(product);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", null);
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = productService.deleteMultiCustom(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/get/{productId}")
    public Product get(@PathVariable("productId") String productId) {
        Product product = productService.queryProductById(productId);
        return product;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Product> get_data() {
        List<Product> list = productService.queryProduct();
        return list;
    }
}
