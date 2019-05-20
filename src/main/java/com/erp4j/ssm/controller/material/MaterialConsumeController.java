package com.erp4j.ssm.controller.material;


import com.erp4j.ssm.pojo.MaterialConsume;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MCVo;
import com.erp4j.ssm.pojo.material.MaterialConsumeVo;
import com.erp4j.ssm.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/materialConsume")
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    @RequestMapping("/find")
    public String findMaterialConsume(){
        return "materialConsume_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVo materialConsumeVo){
        EUDataGridResult result = materialConsumeService.getList(page, rows, materialConsumeVo);
        return result;
    }

    //新增物料消耗验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增物料消耗
    @RequestMapping("/add")
    public String add() {
        return "materialConsume_add";
    }

    //编辑物料消耗验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑物料消耗
    @RequestMapping("/edit")
    public String edit() {
        return "materialConsume_edit";
    }

    //删除物料消耗验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(MaterialConsumeVo materialConsumeVo) {
        boolean flag = materialConsumeService.updateNote(materialConsumeVo);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除物料消耗
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(MCVo mcVo) {
        boolean flag = materialConsumeService.deleteMultiCustom(mcVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //新增物料消耗
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(MaterialConsume materialConsume){
        boolean flag = materialConsumeService.insert(materialConsume);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑物料消耗
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String,Object> update(MaterialConsume materialConsume){
        boolean flag = materialConsumeService.update(materialConsume);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //根据物料消耗id查找
    @RequestMapping("/search_materialConsume_by_consumeId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByConsumeId(page, rows, searchValue);
        return result;
    }

    //根据物料id查找
    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByMaterialId(page, rows, searchValue);
        return result;
    }

    //根据作业id查找
    @RequestMapping("/search_materialConsume_by_workId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByWorkId(page, rows, searchValue);
        return result;
    }
}
