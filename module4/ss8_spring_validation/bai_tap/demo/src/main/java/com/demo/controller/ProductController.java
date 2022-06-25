package com.demo.controller;

import com.demo.dto.ProductDto;
import com.demo.model.Product;
import com.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("product")
    public String displaySong(Model model){
        model.addAttribute("products",iProductService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute @Valid ProductDto productDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("success","Create product successfully");
        return "redirect:/product";
    }
}
