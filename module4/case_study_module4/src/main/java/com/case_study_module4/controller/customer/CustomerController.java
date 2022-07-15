package com.case_study_module4.controller.customer;

import com.case_study_module4.model.customer.Customer;
import com.case_study_module4.service.ICustomerService;
import com.case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String displayList(@PageableDefault(value = 6) Pageable pageable,
                              @RequestParam Optional<String> keyword,
                              Model model){
        String keywordVal=keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("customers", iCustomerService.findAllByName("%"+keywordVal+"%" ,pageable));

        return "customer/listCustomer";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "customer/addCustomer";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Add new successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit")
    public String editCustomer(@RequestParam int id,Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        return "customer/editCustomer";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Edit successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id,RedirectAttributes redirectAttributes){
        iCustomerService.removeById(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/customer/list";
    }
}
