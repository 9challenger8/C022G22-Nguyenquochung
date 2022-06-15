package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {

    @GetMapping(value = "/display")
    public String display() {
        return "convert";
    }
}
