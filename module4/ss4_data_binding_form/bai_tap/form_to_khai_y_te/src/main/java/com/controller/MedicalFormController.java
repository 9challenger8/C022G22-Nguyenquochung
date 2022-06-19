package com.controller;

import com.model.MedicalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalFormController {

    @GetMapping("/medical")
    public String showForm(Model model){
        model.addAttribute("medical", new MedicalForm());
        return "index";
    }

    @PostMapping("/medical")
    public String saveMedic(@ModelAttribute MedicalForm medical,Model model){
            model.addAttribute("medical",medical);
        return "declaration";
    }



}
