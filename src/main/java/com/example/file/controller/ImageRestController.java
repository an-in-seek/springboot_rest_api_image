package com.example.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
@RestController
public class ImageRestController {

    @GetMapping("/img")
    public ResponseEntity<byte[]> getImage() throws Exception{
        log.info("getImage() 호출됨!");
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream("C:\\upload\\image\\post\\read_img.png");
            headers.setContentType(MediaType.IMAGE_PNG);
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }finally {
            in.close();
        }
        return entity;
    }
}
