package com.case_study_module4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String displayNew(){
        return "home";
    }

    @GetMapping("/list")
    public String list(){

        return "employee/listEmployee";
    }

    @GetMapping("/contract")
    public String listA(){
        return "contract/listContract";
    }

    @GetMapping("/add")
    public String edit(){
        return "employee/addEmployee";
    }


}
