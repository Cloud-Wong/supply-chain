package com.cloud.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.spring.model.Company;
import com.cloud.spring.model.Customer;
import com.cloud.spring.service.CustomerService;

@Controller
@SessionAttributes("company")
@RequestMapping("BI-cus")
public class CustomerController {

	private CustomerService customerService;

	@Autowired(required = true)
	public void setCustomerService(CustomerService es) {
		this.customerService = es;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listPersons(@ModelAttribute("company") Company c,Model model) {
		model.addAttribute("customer", new Customer());
		System.out.println(c.getId());
		model.addAttribute("listCustomer", this.customerService.getListByCompany(c.getId()));
		return "basicInfo/customers";
	}

	// For add and update person both
	@RequestMapping(value = "/customer/save", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer e) {

		if (e.getId() == 0) {
			// new person, add it
			this.customerService.save(e);
		} else {
			// existing person, call update
			this.customerService.update(e);
		}

		return "redirect:/BI-cus/customer";

	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.customerService.delete(id);
		return "redirect:/BI-cus/customer";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getById(id));
		model.addAttribute("listCustomer", this.customerService.getAll());
		return "basicInfo/customers";
	}

}
