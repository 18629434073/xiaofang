package com.ht.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by UPC on 2016/12/12.
 */
public class FileUpload {
    public static final String FILE_PATH = "C:/upload/";

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        if("".equals(fileName)||fileName==null){
            return null;
        }
        File tempFile = new File(FILE_PATH, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return  tempFile.getPath();
    }

    public static File getFile(String fileName) {
        return new File(FILE_PATH, fileName);
    }
}
