package com.blog_uprade.controller;


import com.blog_uprade.model.Blog;
import com.blog_uprade.model.Category;
import com.blog_uprade.service.IBLogService;
import com.blog_uprade.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBLogService iBLogService;

    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("")
    public String showListBlog(Model model,
                           @PageableDefault(value = 6) Pageable pageable,
                           @RequestParam Optional<String> keyword ){
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("blogs", iBLogService.findAllByName("%"+keywordVal+"%" ,pageable));
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "list_blog";
    }

    @GetMapping("/category")
    public String showListCategory(Model model){
        model.addAttribute("category",iCategoryService.findAll());
        return "list_category";
    }

    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "create_blog";
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
        return "edit_blog";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute Blog blog){
        iBLogService.save( blog);
        return "redirect:/blog";
    }

    @GetMapping("/category/{id}/edit")
    public String editCategory(@PathVariable int id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "edit_category";
    }

    @PostMapping("/category/edit")
    public String editCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/blog/category";
    }

    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable int id, Model model){
        model.addAttribute("blog", iBLogService.findById(id));
        return "delete_blog";
    }

    @PostMapping("/delete")
    public String deleteSong(@ModelAttribute Blog blog,RedirectAttributes redirect){
        redirect.addFlashAttribute("success", "Removed product successfully!");
        iBLogService.remove(blog.getId());
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String viewBLog(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBLogService.findById(id));
        return "/view_blog";
    }
}
