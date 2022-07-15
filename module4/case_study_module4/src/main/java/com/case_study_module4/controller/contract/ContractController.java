package com.case_study_module4.controller.contract;


import com.case_study_module4.model.contract.AttachFacility;
import com.case_study_module4.model.contract.Contract;
import com.case_study_module4.model.contract.ContractDetail;
import com.case_study_module4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/list")
    public String displayList(@PageableDefault(value = 6) Pageable pageable,
                              @RequestParam Optional<String> keyword,
                              Model model){
        String keywordVal=keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("contracts", iContractService.findAllByStartDate("%"+keywordVal+"%" ,pageable));
        return "contract/listContract";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("facilities",iFacilityService.findAll());
        model.addAttribute("customers",iCustomerService.findAll());
        model.addAttribute("employees",iEmployeeService.findAll());
        model.addAttribute("attachFacilities",iAttachFacilityService.findAll());
        model.addAttribute("contract",new Contract());
        return "contract/addContract";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes,
                                 @RequestParam String attachFacilityId, @RequestParam String quantity){
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Add new successfully!");
        AttachFacility attachFacility = new AttachFacility();
        attachFacility.setId(Integer.valueOf(attachFacilityId));
        ContractDetail contractDetail=new ContractDetail(quantity,attachFacility,contract);
        iContractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
