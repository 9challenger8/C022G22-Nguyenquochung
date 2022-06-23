package com.blog.controller;


import com.blog.model.Blog;
import com.blog.service.IBLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBLogService iBLogService;


    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogs", iBLogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBLog(@ModelAttribute Blog blog, RedirectAttributes redirect){
        redirect.addFlashAttribute("success", "Add new successfully!");
        iBLogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String editSong(@PathVariable int id, Model model){
        model.addAttribute("blog", iBLogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute Blog blog){
        iBLogService.save( blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable int id, Model model){
        model.addAttribute("blog", iBLogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteSong(@ModelAttribute Blog blog,RedirectAttributes redirect){
        redirect.addFlashAttribute("success", "Removed product successfully!");
        iBLogService.remove(blog.getId());
        return "redirect:/blog";
    }
}
