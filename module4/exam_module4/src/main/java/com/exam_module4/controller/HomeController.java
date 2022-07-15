package com.exam_module4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping("/form")
    public String displayForm(){
        return "add";
    }

    @GetMapping("/list")
    public String displayList(){
        return "list";
    }

}
