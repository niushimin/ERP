package com.erp4j.ssm.controller.upload;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 16:30
 * @Description:
 */

@Controller
@RequestMapping("/pic")
public class PictureUploadController {

    @ResponseBody
    @RequestMapping("/upload")
    public Map<String, Object> picUpload(MultipartFile uploadFile, HttpServletRequest request) {
        // 获取原始的文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        long timeMillis = System.currentTimeMillis();
        String newFile = timeMillis + originalFilename.substring(originalFilename.lastIndexOf("."));
        String realPath = request.getSession().getServletContext().getRealPath("/pic");
        File filename = new File(realPath);
        String contextPath = request.getContextPath();
        if (!filename.exists()) {
            filename.mkdirs();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            uploadFile.transferTo(new File(realPath, newFile));
            map.put("error", 0);
            map.put("url", contextPath + "/pic/" + newFile);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Map<String, Object> delete(String picName, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String filename = picName.substring(contextPath.length());
        String realPath = request.getSession().getServletContext().getRealPath("");
        File file = new File(realPath, filename);
        if (file.exists()) {
            file.delete();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }
}
