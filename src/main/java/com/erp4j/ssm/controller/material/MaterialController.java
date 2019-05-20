package com.erp4j.ssm.controller.material;


import com.erp4j.ssm.pojo.Material;
import com.erp4j.ssm.pojo.device.DeviceCheckVo;
import com.erp4j.ssm.pojo.device.DeviceVo;
import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MVo;
import com.erp4j.ssm.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page, Integer rows, Material material) {
        EUDataGridResult result = materialService.getList(page, rows, material);
        return result;
    }

    @RequestMapping("/find")
    public String findMaterial(){
        return "material_list";
    }

    //新增物料信息验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "msg";
    }

    //新增物料信息
    @RequestMapping("/add")
    public String add() {
        return "material_add";
    }

    //编辑物料信息验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "msg";
    }

    //编辑物料信息
    @RequestMapping("/edit")
    public String edit() {
        return "material_edit";
    }

    //删除物料信息验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "msg";
    }

    //获取物料详细信息
    @RequestMapping("/get/{materialId}")
    @ResponseBody
    public Material getItemById(@PathVariable String materialId) {
        Material material = materialService.get(materialId);
        return material;
    }

    //获取所有设备信息
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> getData() {
        List<Material> list = materialService.find();
        return list;
    }


    //更新note
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> update_note(Material material) {
        boolean flag = materialService.updateNote(material);
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //删除物料信息
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> delete_batch(MVo mVo) {
        boolean flag = materialService.deleteMultiCustom(mVo.getIds());
        Map<String, Object> map = new HashMap<>();
        if (flag) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }
        return map;
    }

    //新增物料信息
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(Material material){
        boolean flag = materialService.insert(material);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //编辑物料信息
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String,Object> update(Material material){
        boolean flag = materialService.update(material);
        Map<String, Object> map = new HashMap<>();
        if (flag){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
        }
        return map;
    }

    //根据物料id查找
    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialByMaterialId(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialService.searchMaterialByMaterialId(page, rows, searchValue);
        return result;
    }

    //根据物料类型查找
    @RequestMapping("/search_material_by_materialType")
    @ResponseBody
    public EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows, String searchValue)
            {
        EUDataGridResult result = materialService.searchMaterialByMaterialType(page, rows, searchValue);
        return result;
    }
}
