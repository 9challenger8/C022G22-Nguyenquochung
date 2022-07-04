package com.blog_uprade.rest;


import com.blog_uprade.model.Blog;
import com.blog_uprade.service.IBLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog/api")
public class BlogRestController {

    @Autowired
    private IBLogService iBLogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showListBlog(){
        List<Blog> blogList=iBLogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }




}
