package com.erp4j.ssm.controller.process;

import com.erp4j.ssm.pojo.process.Process;
import com.erp4j.ssm.service.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/5/19 15:01
 * @Description:
 */

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @ResponseBody
    @RequestMapping("/get/{processId}")
    public Process get(@PathVariable String processId) {
        Process process = processService.queryProcessById(processId);
        return process;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Process> get_data() {
        List<Process> list = processService.queryProcess();
        return list;
    }
}
