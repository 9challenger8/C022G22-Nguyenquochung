package com.case_study_module4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String display(){
        return "home";
    }

    @GetMapping("/list")
    public String list(){
        return "/service/list";
    }

    @GetMapping("/edit")
    public String edit(){
        return "/service/edit";
    }


}
