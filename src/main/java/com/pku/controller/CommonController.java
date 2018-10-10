package com.pku.controller;


import com.pku.domain.*;
import com.pku.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@CrossOrigin
@RestController

@RequestMapping({"/common"})
public class CommonController {

    @Autowired
    AdminService adminService;

    @Value("${file.uploadFolder}/")
    private String uploadFolder;


    /**
     * 单文件上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public RespEntity upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            // File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            File saveFile = new File(uploadFolder+ saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                String url = "http://127.0.0.1:66/file/" + saveFileName;  // 文件服务器地址
                return new RespEntity(RespCode.SUCCESS, url);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new RespEntity(RespCode.WARN, "");
            } catch (IOException e) {
                e.printStackTrace();
                return new RespEntity(RespCode.WARN, "");
            }
        } else {
            return new RespEntity(RespCode.WARN, "");
        }
    }


}
