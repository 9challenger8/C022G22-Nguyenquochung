package com.case_study_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/furama")
public class Controller {

    @GetMapping("")
    public String display(){
        return "list";
    }




}
