package com.erp4j.ssm.controller.corder;

import com.erp4j.ssm.pojo.QueryVo;
import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.pojo.product.Product;
import com.erp4j.ssm.service.corder.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/17 16:40
 * @Description:
 */

@Controller
@RequestMapping("/corder")
public class COrderController {

    @Autowired
    COrderService orderService;

    // 从主页查看订单列表信息
    @RequestMapping("/find")
    public String find() {
        return "order_list";
    }

    // 返回订单列表的数据
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(int page, int rows) {
        List<COrder> list = orderService.queryCOrder(page, rows);
        int total = orderService.queryTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 新增订单信息权限校验
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map<String, Object> add_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转新增订单信息页面
    @RequestMapping("/add")
    public String add() {
        return "order_add";
    }

    // 保存订单信息
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(QueryVo queryVo) {
        boolean flag = orderService.insertCOrder(queryVo);
        HashMap<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 修改订单信息权限校验
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map<String, Object> edit_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到修改订单信息页面
    @RequestMapping("/edit")
    public String edit() {
        return "order_edit";
    }

    // 将修改的信息保存到数据库中
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update_all(QueryVo queryVo) {
        boolean flag = orderService.updateCOrder(queryVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }


    // 删除订单信息权限校验
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete_judge() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    // 批量删除订单信息
    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> delete_batch(QueryVo queryVo) {
        boolean flag = orderService.deleteMultiCOrder(queryVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    // 根据订单Id获取订单信息
    @ResponseBody
    @RequestMapping("/get/{cOrderId}")
    public COrder get(@PathVariable String cOrderId) {
        COrder cOrder = orderService.queryCOrderById(cOrderId);
        return cOrder;
    }

    // 获取所有的订单信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<COrder> get_data() {
        List<COrder> list = orderService.queryCOrder();
        return list;
    }

    // 根据订单Id查询订单信息
    @ResponseBody
    @RequestMapping("/search_order_by_orderId")
    public Map<String, Object> search_order_by_orderId(String searchValue, int page, int rows) {
        List<COrder> list = orderService.queryCOrderById(searchValue, page, rows);
        int total = orderService.queryTotalById(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据客户名称查询订单信息
    @ResponseBody
    @RequestMapping("/search_order_by_orderCustom")
    public Map<String, Object> search_product_by_productName(String searchValue, int page, int rows) {
        List<COrder> list = orderService.queryCOrderByCustom(searchValue, page, rows);
        int total = orderService.queryTotalByCustom(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 根据产品名称查询订单信息
    @ResponseBody
    @RequestMapping("/search_order_by_orderProduct")
    public Map<String, Object> search_product_by_productType(String searchValue, int page, int rows) {
        List<COrder> list = orderService.queryCOrderByProduct(searchValue, page, rows);
        int total = orderService.queryTotalByProduct(searchValue);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
