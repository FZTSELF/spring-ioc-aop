package com.fzt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    ApplicationContext app;

    @GetMapping("/index")
    public String index(Model model){
        System.out.println(app.getClass());
        System.out.println(app.getBean("multipartResolver"));
        return "hello";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String filePath="E://test"+file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "success";
    }


    @GetMapping("/user")
    @ResponseBody
    public String userInfo(Model model){
        User user=new User("hhh","nan");
        return user.toString();
    }

}
