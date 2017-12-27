package com.cloud.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cloud.spring.model.Company;
import com.cloud.spring.service.CompanyService;

@Controller
@SessionAttributes("company")
@RequestMapping("BI-com")
public class CompanyController {

	private CompanyService companyService;

	@Autowired(required = true)
	public void setCompanyService(CompanyService es) {
		this.companyService = es;
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("company", new Company());
		model.addAttribute("listCompany", this.companyService.getAll());
		return "basicInfo/companys";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("company", new Company());
		return "basicInfo/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("company") Company c,Model model){
		System.out.println("登陆");
		if(companyService.login(c)){
			model.addAttribute("company", c);
			return "redirect:/index.jsp";
		}
		System.out.println("登陆失败");
		return "redirect:/BI-com/login";
	}
	
	@RequestMapping("/logout")  
    public String logout(@ModelAttribute("company") Company company, SessionStatus sessionStatus){     
        sessionStatus.setComplete();  
        return "redirect:/BI-com/login";  
    }  

	// For add and update person both
	@RequestMapping(value = "/company/save", method = RequestMethod.POST)
	public String register(@ModelAttribute("company") Company e) {

		if (e.getId() == 0) {
			// new person, add it
			this.companyService.save(e);
		} else {
			// existing person, call update
			this.companyService.update(e);
		}

		return "basicInfo/login";

	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.companyService.delete(id);
		return "redirect:/BI-com/company";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("company", this.companyService.getById(id));
		model.addAttribute("listCompany", this.companyService.getAll());
		return "basicInfo/companys";
	}

}
