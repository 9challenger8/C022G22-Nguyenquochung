package com.ung_dung_thu_vien.controller;

import com.ung_dung_thu_vien.repository.IBookDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookDetail")
public class BookDetailController {

    @Autowired
    private IBookDetailRepository iBookDetailRepository;

    @GetMapping("/display")
    public String displayBookDetail(Model model){
        model.addAttribute("bookDetails",iBookDetailRepository.findAll());
        return "list_detail";
    }

    @GetMapping("/borrow")
    public String borrowBook(){

        return "redirect:/bookDetail/display";
    }

    @GetMapping("/borrow")
    public String giveBookBack(){

        return "redirect:/bookDetail/display";
    }


}
