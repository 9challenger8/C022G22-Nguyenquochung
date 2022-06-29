package com.ung_dung_thu_vien.controller;

import com.ung_dung_thu_vien.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookRepository iBookRepository;

    @GetMapping("/display")
    public String display(Model model){
        model.addAttribute("books",iBookRepository.findAll());
        return "list";
    }


}
