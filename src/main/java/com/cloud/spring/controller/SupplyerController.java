package com.cloud.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.spring.model.Company;
import com.cloud.spring.model.Supplyer;
import com.cloud.spring.service.SupplyerService;

@Controller
@RequestMapping("BI-sup")
public class SupplyerController {

	private SupplyerService supplyerService;

	@Autowired(required = true)
	public void setSupplyerService(SupplyerService es) {
		this.supplyerService = es;
	}

	@RequestMapping(value = "/supplyer", method = RequestMethod.GET)
	public String listPersons(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("supplyer", new Supplyer());
		model.addAttribute("listSupplyer", this.supplyerService.getListByCompany(c.getId()));
		return "basicInfo/supplyers";
	}

	// For add and update person both
	@RequestMapping(value = "/supplyer/save", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("supplyer") Supplyer e) {

		if (e.getId() == 0) {
			// new person, add it
			this.supplyerService.save(e);
		} else {
			// existing person, call update
			this.supplyerService.update(e);
		}

		return "redirect:/BI-sup/supplyer";

	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.supplyerService.delete(id);
		return "redirect:/BI-sup/supplyer";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("supplyer", this.supplyerService.getById(id));
		model.addAttribute("listSupplyer", this.supplyerService.getListByCompany(c.getId()));
		return "basicInfo/supplyers";
	}

}
