package com.codegym.controller;

import com.codegym.service.IConvertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService iConvertService;

    @GetMapping(value = "/convert")
    public String goGreeting(@RequestParam int num1, Model model) {
        int result= this.iConvertService.convert(num1);
        model.addAttribute("result",result);
        return "convert";
    }


}
