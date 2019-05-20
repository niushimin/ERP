package com.erp4j.ssm.controller.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/5/20 16:29
 * @Description:
 */

@Controller
@RequestMapping("/file")
public class FileUploadController {


    @ResponseBody
    @RequestMapping("/upload")
    public Map<String, Object> upload(MultipartFile file, HttpServletRequest request) {
        // 获取原始的文件名称
        String originalFilename = file.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/file");
        File filename = new File(realPath);
        String contextPath = request.getContextPath();
        if (!filename.exists()) {
            filename.mkdirs();
        }
        // 判断是否有同名文件
        int count = 0;
        String[] list = filename.list();
        for (String s : list) {
            if (originalFilename.equals(s)) {
                count++;
            }
        }
        if (count != 0) {
            String newFile = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            originalFilename = newFile + "(" + (count) + ")" + suffix;
        }


        HashMap<String, Object> map = new HashMap<>();
        try {
            file.transferTo(new File(realPath, originalFilename));
            map.put("error", 0);
            map.put("url", contextPath + "/file/" + originalFilename);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
        }
        return map;
    }

    @RequestMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(fileName);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Map<String, Object> delete(String fileName, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String filename = fileName.substring(contextPath.length());
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
