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
import com.cloud.spring.model.Inventory;
import com.cloud.spring.service.InventoryService;
import com.cloud.spring.service.ProductService;

@Controller
@RequestMapping("IM-inv")
public class InventoryController {

	private InventoryService inventoryService;
	private ProductService productService;

	@Autowired(required = true)
	public void setInventoryService(InventoryService es) {
		this.inventoryService = es;
	}
	
	@Autowired(required = true)
	public void setProductService(ProductService es) {
		this.productService = es;
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String listPersons(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("inventory", new Inventory());
		model.addAttribute("listInventory", this.inventoryService.getListByCompany(c.getId()));
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		return "inventorymana/inventorys";
	}

	
	@RequestMapping(value = "/inventory/save", method = RequestMethod.POST)
	public String add(@ModelAttribute("inventory") Inventory e) {

		if (e.getId() == 0) {
			// new person, add it
			this.inventoryService.save(e);
		} else {
			// existing person, call update
			this.inventoryService.update(e);
		}

		return "redirect:/IM-inv/inventory";

	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.inventoryService.delete(id);
		return "redirect:/IM-inv/inventory";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("inventory", this.inventoryService.getById(id));
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		model.addAttribute("listInventory", this.inventoryService.getListByCompany(c.getId()));
		return "inventorymana/inventorys";
	}

}
