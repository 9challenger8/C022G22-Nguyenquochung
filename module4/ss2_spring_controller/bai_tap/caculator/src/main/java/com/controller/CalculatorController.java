package com.controller;

import com.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;


    @GetMapping("/display")
    public  String display(){
        return "index";
    }

    @GetMapping("/calculator")
    public String Addition(@RequestParam int num1, @RequestParam int num2, Model model){
        int sum = this.iCalculatorService.sum(num1,num2);
        model.addAttribute("sum",sum);
        int mul =this.iCalculatorService.mul(num1,num2);
        model.addAttribute("mul",mul);
        double div1 =this.iCalculatorService.div(num1,num2);
        model.addAttribute("div1",div1);
        int sub = this.iCalculatorService.sub(num1,num2);
        model.addAttribute("sub",sub);
        return "index";
    }
  
}
