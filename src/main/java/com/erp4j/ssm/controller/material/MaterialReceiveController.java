package com.erp4j.ssm.controller.material;


import com.erp4j.ssm.pojo.MaterialReceive;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MRVo;
import com.erp4j.ssm.pojo.material.MaterialReceiveVo;
import com.erp4j.ssm.service.material.MaterialReceiveService;
import com.erp4j.ssm.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("/find")
    public String findMaterialReceive(){
        return "materialReceive_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows) {
        EUDataGridResult result = materialReceiveService.getList(page, rows);
        return result;
    }

    //新增物料收入验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增物料收入
    @RequestMapping("/add")
    public String add() {
        return "materialReceive_add";
    }

    //编辑物料收入验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑物料收入
    @RequestMapping("/edit")
    public String edit() {
        return "materialReceive_edit";
    }

    //删除物料收入验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(MaterialReceiveVo materialReceiveVo) {
        boolean flag = materialReceiveService.updateNote(materialReceiveVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除物料收入
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(MRVo mrVo) {
        boolean flag = materialReceiveService.deleteMultiCustom(mrVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //新增物料收入
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(MaterialReceive materialReceive){
        boolean flag = materialReceiveService.insert(materialReceive);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑物料收入
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String,Object> update(MaterialReceive materialReceive){
        boolean flag = materialReceiveService.update(materialReceive);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //根据物料接收id查找
    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public EUDataGridResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialReceiveService.searchMaterialReceiveByReceiveId(page, rows, searchValue);
        return result;
    }

    //根据物料id查找
    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialReceiveByMaterialId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialReceiveService.searchMaterialReceiveByMaterialId(page, rows, searchValue);
        return result;
    }
}
