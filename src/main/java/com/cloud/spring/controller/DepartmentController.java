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
import com.cloud.spring.model.Department;
import com.cloud.spring.service.DepartmentService;

@Controller
@RequestMapping("BI-dep")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@Autowired(required=true)
	public void setPersonService(DepartmentService es){
		this.departmentService = es;
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String listPersons(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("department", new Department());
		model.addAttribute("listDepartment", this.departmentService.getListByCompany(c.getId()));
		return "basicInfo/departments";
	}
	
	
	@RequestMapping(value= "/department/save", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("department") Department e){
		
		if(e.getId() == 0){
			//new person, add it
			this.departmentService.save(e);
		}else{
			//existing person, call update
			this.departmentService.update(e);
		}
		
		return "redirect:/BI-dep/department";
		
	}
	
	@RequestMapping("/delete/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.departmentService.delete(id);
        return "redirect:/BI-dep/department";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model,HttpSession session){
    	Company c = (Company)session.getAttribute("company");
        model.addAttribute("department", this.departmentService.getById(id));
		model.addAttribute("listDepartment", this.departmentService.getListByCompany(c.getId()));
		return "basicInfo/departments";
    }
	
}