package com.maike.myblog.utils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public class UploadImgUtils {
    /**
     * 上传文件（这里是上传图片）
     * @param file  文件
     * @param request
     * @return
     */
    @PostMapping("/uploadImg")
    public static String uploadImg(@RequestParam("file") MultipartFile file,
                            String filePath,
                            HttpServletRequest request) {
        //TODO 判断文件格式是不是图片
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        fileName=GetId.addLeftZero(GetId.getLocalTrmSeqNum(),20)+".jpg";
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回json
        return fileName;
    }
}
