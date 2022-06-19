package com.controller;

import com.model.EmailConfiguration;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/update")
    public String display(Model model){
        model.addAttribute("emailConfiguration", new  EmailConfiguration() );
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmailConfiguration emailConfiguration , Model model){
            model.addAttribute("languages",emailConfiguration.getLanguages());
            model.addAttribute("pageSize",emailConfiguration.getPageSize());
            model.addAttribute("spamFilter",emailConfiguration.isSpamFilter());
            model.addAttribute("signature",emailConfiguration.getSignature());
        return "index";
    }

}
