package com.case_study_module4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/display")
    public String display(){
        return "home";
    }

    @GetMapping("list")
    public String list(){
        return "list";
    }


}
