package com.erp4j.ssm.controller.product;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrderVo;
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
        boolean flag = productService.insertProduct(product);
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
        boolean flag = productService.updateProduct(product);
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
        boolean flag = productService.deleteMultiProduct(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据产品Id获取产品信息
    @ResponseBody
    @RequestMapping("/get/{productId}")
    public Product get(@PathVariable("productId") String productId) {
        Product product = productService.queryProductById(productId);
        return product;
    }

    // 获取所有的产品信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Product> get_data() {
        List<Product> list = productService.queryProduct();
        return list;
    }

    // 修改订单要求信息
    @ResponseBody
    @RequestMapping("/update_note")
    public Map<String, Object> update_note(Product product) {
        boolean flag = productService.updateProduct(product);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据产品Id查询商品信息
    @ResponseBody
    @RequestMapping("/search_product_by_productId")
    public Map<String, Object> search_product_by_productId(String searchValue, int page, int rows) {
        List<Product> list = productService.queryProductById(searchValue, page, rows);
        int total = productService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据产品名称查询商品信息
    @ResponseBody
    @RequestMapping("/search_product_by_productName")
    public Map<String, Object> search_product_by_productName(String searchValue, int page, int rows) {
        List<Product> list = productService.queryProductByName(searchValue, page, rows);
        int total = productService.queryTotalByName(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据产品种类查询商品信息
    @ResponseBody
    @RequestMapping("/search_product_by_productType")
    public Map<String, Object> search_product_by_productType(String searchValue, int page, int rows) {
        List<Product> list = productService.queryProductByType(searchValue, page, rows);
        int total = productService.queryTotalByType(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
