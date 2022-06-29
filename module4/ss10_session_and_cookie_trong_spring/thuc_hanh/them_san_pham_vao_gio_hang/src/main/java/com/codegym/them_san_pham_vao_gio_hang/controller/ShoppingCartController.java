package com.codegym.them_san_pham_vao_gio_hang.controller;

import com.codegym.them_san_pham_vao_gio_hang.model.Cart;
import com.codegym.them_san_pham_vao_gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Long id){
        model.addAttribute("product", this.iProductService.findById(id));
        return "view";
    }
}
