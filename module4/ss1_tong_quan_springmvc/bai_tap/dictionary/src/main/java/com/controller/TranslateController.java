package com.controller;


import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping(value = "/translate")
    public String translate(@RequestParam String word1, Model model){
        String word2=this.iDictionaryService.translate(word1);
        model.addAttribute("word",word2);
        return "dictionary";
    }

}
