package com.erp4j.ssm.controller.technology;

import com.erp4j.ssm.pojo.technology.Technology;
import com.erp4j.ssm.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 18:05
 * @Description:
 */

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    // 根据工艺Id获取工艺信息
    @ResponseBody
    @RequestMapping("/get/{technologyId}")
    public Technology get(@PathVariable("technologyId") String technologyId) {
        Technology technology = technologyService.queryTechnologyById(technologyId);
        return technology;
    }

    // 获取所有的工艺信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Technology> get_data() {
        List<Technology> list = technologyService.queryTechnology();
        return list;
    }
}
