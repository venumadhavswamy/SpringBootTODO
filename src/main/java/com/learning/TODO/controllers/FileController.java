package com.learning.TODO.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    public String uploadSingleFile(@RequestParam("image")MultipartFile file){
        logger.info(file.getOriginalFilename());
        logger.info(file.getName());
        logger.info(""+file.getSize());
        return "file uploaded";
    }

    @PostMapping("/multiple")
    public void uploadMultipleFiles(@RequestParam("file") MultipartFile[] files){
        Arrays.stream(files).forEach((file)->{
            logger.info("file name: "+ file.getOriginalFilename());
            logger.info(file.getSize()+"");
            System.out.println("**********************");
        });
    }

    @GetMapping("download-image")
    public void downloadImage(HttpServletResponse response){
        try{
            FileInputStream fileInputStream = new FileInputStream("images/sample1.jpeg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());
        }
        catch(Exception e){

        }
    }
}
