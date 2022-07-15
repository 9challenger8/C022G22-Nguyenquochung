package com.case_study_module4.controller.facility;


import com.case_study_module4.model.customer.Customer;
import com.case_study_module4.model.facility.Facility;
import com.case_study_module4.service.IFacilityService;
import com.case_study_module4.service.IFacilityTypeService;
import com.case_study_module4.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String displayList(@PageableDefault(value = 6) Pageable pageable,
                              @RequestParam Optional<String> keyword,
                              Model model){

        String keywordVal=keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("facilities", iFacilityService.findAllByName("%"+keywordVal+"%" ,pageable));
        model.addAttribute("facilityTypes",iFacilityTypeService.findAll());
        model.addAttribute("rentTypes",iRentTypeService.findAll());
        return "facility/listFacility";
    }

    @GetMapping("/create")
    public String createFacility(Model model){
        model.addAttribute("facilityTypes",iFacilityTypeService.findAll());
        model.addAttribute("rentTypes",iRentTypeService.findAll());
        model.addAttribute("facility",new Facility());
        return "facility/addFacility";
    }

    @PostMapping("/create")
    public String createFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("success", "Add new successfully!");
        return "redirect:/facility/list";
    }

    @GetMapping("/{id}/edit")
    public String editFacility(@PathVariable int id,Model model){
        model.addAttribute("facility",iFacilityService.findById(id));
        model.addAttribute("facilityTypes",iFacilityTypeService.findAll());
        model.addAttribute("rentTypes",iRentTypeService.findAll());
        return "facility/editFacility";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute Facility facility,RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("success", "Edit successfully!");
        return "redirect:/facility/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFacility(@PathVariable int id,RedirectAttributes redirectAttributes){
        iFacilityService.removeById(id);
        redirectAttributes.addFlashAttribute("success", "Delete successfully!");
        return "redirect:/facility/list";
    }





}
