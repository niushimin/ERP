package com.erp4j.ssm.controller.material;


import com.erp4j.ssm.pojo.device.EUDataGridResult;
import com.erp4j.ssm.pojo.material.MaterialConsumeVo;
import com.erp4j.ssm.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
