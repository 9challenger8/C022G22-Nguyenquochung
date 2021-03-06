package com.ung_dung_thu_vien.controller;

import com.ung_dung_thu_vien.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookRepository iBookRepository;

    @GetMapping("/display")
    public String displayBook(Model model){
        model.addAttribute("books",iBookRepository.findAll());
        return "list_book";
    }

    @GetMapping("/detail/{id}")
    public String detailBook(@PathVariable int id,Model model){
        model.addAttribute("book",iBookRepository.findById(id));
        return "view";
    }



    @ExceptionHandler(Exception.class)
    public String goErrorBook(){
        return "error_book";
    }


}
