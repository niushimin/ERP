package com.erp4j.ssm.controller.corder;

import com.erp4j.ssm.pojo.corder.COrder;
import com.erp4j.ssm.service.corder.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/order")
public class COrderController {

    @Autowired
    COrderService orderService;

    @RequestMapping("/find")
    public String find() {
        return "order_list";
    }

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

}
