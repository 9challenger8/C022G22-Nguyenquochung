package com.exam_module4.controller;

import com.exam_module4.model.Contract;
import com.exam_module4.service.IContractService;
import com.exam_module4.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IRoomService iRoomService;

    @GetMapping("/list")
    public String findAllContract(Model model){

        model.addAttribute("contracts",iContractService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateContract(Model model){
        model.addAttribute("rooms",iRoomService.findAll());
        model.addAttribute("contract",new Contract());
        return "add";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        iContractService.save(contract);
        iRoomService.updateToHired(contract.getRoom().getId());
        redirectAttributes.addFlashAttribute("success", "Add new successfully!");
        return "redirect:/contract/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable String id, RedirectAttributes redirectAttributes){
        iRoomService.updateToAvailable(iContractService.findById(id).getRoom().getId());
        iContractService.removeById(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/contract/list";
    }
}
