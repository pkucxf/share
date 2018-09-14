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

    @Value("${file.uploadFolder}")
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




    @RequestMapping(value="/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getUserInfo(){
        List<UserInfo> list ;
        list =  adminService.queryUserInfo();
        return  new RespEntity(RespCode.SUCCESS, list);
    }

    @RequestMapping(value="/delUser",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delUser(@Param("id") int id ){
        Boolean b  = adminService.delUserInfo(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }
    }
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity updateUser(@RequestBody UserInfo userInfo){
        Boolean result ;
        result = adminService.updateUserInfo(userInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }



    @RequestMapping(value="/getCarType",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarType(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<CarType> list ;
        list =  adminService.queryCarType(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list);
    }

    @RequestMapping(value="/addCarType",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addCarType(@RequestBody CarType carType){
        Boolean result ;
        result = adminService.addCarType(carType);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }

    @RequestMapping(value="/delCarType",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delCarType(@Param("id") int id ){
        Boolean b ;
        b = adminService.delCarType(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }

    }


    @RequestMapping(value="/getStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<StoreInfo> list2 ;
        list2 = adminService.queryStore(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list2);
    }

    @RequestMapping(value="/addStore",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addStore(@RequestBody StoreInfo storeInfo){
        Boolean result ;
        result = adminService.addStore(storeInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }

    @RequestMapping(value="/delStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delStore(@Param("id") String id ){
        Boolean b ;
        b = adminService.delStore(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }
    }

    /*店铺车辆关系*/
    @RequestMapping(value="/getCarAndStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarAndStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<CarAndStore> list2 ;
        list2 = adminService.queryCarAndStore(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list2);
    }

    @RequestMapping(value="/addCarAndStore",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addCarAndStore(@RequestBody CarAndStore carAndStore){
        Boolean result ;
        result = adminService.addCarAndStore(carAndStore);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }



}
