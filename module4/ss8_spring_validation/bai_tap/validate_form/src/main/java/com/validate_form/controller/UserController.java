package com.validate_form.controller;

import com.validate_form.dto.UserDto;
import com.validate_form.model.User;
import com.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public String displayUserList(Model model ){
        model.addAttribute("users",iUserService.findAll());

        return "list_user";
    }

    @GetMapping("/create")
    public String showUserCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create_user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Valid UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "create_user";
        }
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        this.iUserService.save(user);
        redirectAttributes.addFlashAttribute("success","Create user successfully");
        return "redirect:/user";
    }

}
