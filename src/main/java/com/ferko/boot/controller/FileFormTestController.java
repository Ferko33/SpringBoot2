package com.ferko.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileFormTestController {

    @GetMapping(value = {"/form_layouts","/form_layouts.html"})
    public String form_layouts() {
        return "form/form_layouts";
    }


    /**
     * MultipartFile 自动封装上传的文件
     *
     * @param email
     * @param pwd
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("passWord") String pwd,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={},passWord={},headerImg={},photos={}",
                email, pwd, headerImg.getSize(), photos.length);
        if (!headerImg.isEmpty()) {
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\test_photo\\" + originalFilename));
                }
            }
        }
        return "redirect:/form_layouts";
    }
}
