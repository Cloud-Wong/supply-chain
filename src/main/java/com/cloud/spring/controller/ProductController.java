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
import com.cloud.spring.model.Product;
import com.cloud.spring.service.ProductService;

@Controller
@RequestMapping("BI-pro")
public class ProductController {

	private ProductService productService;

	@Autowired(required = true)
	public void setProductService(ProductService es) {
		this.productService = es;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listPersons(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("product", new Product());
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		return "basicInfo/products";
	}

	// For add and update person both
	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("product") Product e) {

		if (e.getId() == 0) {
			// new person, add it
			this.productService.save(e);
		} else {
			// existing person, call update
			this.productService.update(e);
		}

		return "redirect:/BI-pro/product";

	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.productService.delete(id);
		return "redirect:/BI-pro/product";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("product", this.productService.getById(id));
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		return "basicInfo/products";
	}

}
