package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.servise.ServiceCompany;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final ServiceCompany serviceCompany;

    @Autowired
    public CompanyController(ServiceCompany serviceCompany) {
        this.serviceCompany = serviceCompany;
    }
    @GetMapping
    public String getAllCompany(Model model) {
        model.addAttribute("companies", serviceCompany.getAllCompany());
        return "main-page";
    }


    @GetMapping("/new")
    public String newCompany(@ModelAttribute("company")Company company) {
        //Добавляем компанию в БД

        return "addCompany";
    }

    @PostMapping("/save")
    public String addCompany(@ModelAttribute("company") Company company) {
        serviceCompany.saveCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/{id}/edit")
    public String editCompany(@PathVariable("id")int id,Model model){
        model.addAttribute("company",serviceCompany.getById(id));
        return "updateCompany";
    }

    @PatchMapping ("/{id}")
    public String updateCompany(@ModelAttribute("company")Company company,@PathVariable("id") int id,Model model){
        serviceCompany.update(id, company);
        model.addAttribute("company",company);
        return "redirect:/companies";
    }

    @GetMapping("/{id}")
    public String deleteCompany(@PathVariable("id")int id ){
        serviceCompany.removeCompanyById(id);
        return "redirect:/companies";
    }
    @GetMapping("/open")
    public String openCompany(){
        return "company-page";
    }

//@ModelAttribute("headerMessage")
//    public String companyMessage(){
//    return "Welcom to our vebsite!";
//}







}
