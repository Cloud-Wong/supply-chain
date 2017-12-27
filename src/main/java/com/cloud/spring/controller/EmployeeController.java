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
import com.cloud.spring.model.Employee;
import com.cloud.spring.service.DepartmentService;
import com.cloud.spring.service.EmployeeService;

@Controller
@RequestMapping("BI-emp")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	@Autowired(required=true)
	public void setDepartmentService(DepartmentService ds){
		this.departmentService = ds;
	}
	
	@Autowired(required=true)
	public void setEmployeeService(EmployeeService es){
		this.employeeService = es;
	}
	           
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listPersons(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", this.employeeService.getListByCompany(c.getId()));
		model.addAttribute("listDepartment", this.departmentService.getListByCompany(c.getId()));
		return "basicInfo/employees";
	}
	
	//For add and update person both
	@RequestMapping(value= "/employee/save", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") Employee e){
		
		if(e.getId() == 0){
			//new person, add it
			this.employeeService.save(e);
		}else{
			//existing person, call update
			this.employeeService.update(e);
		}
		
		return "redirect:/BI-emp/employee";
		
	}
	
	@RequestMapping("/delete/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.employeeService.delete(id);
        return "redirect:/BI-emp/employee";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model,HttpSession session){
    	Company c = (Company)session.getAttribute("company");
        model.addAttribute("employee", this.employeeService.getById(id));
        model.addAttribute("listEmployee", this.employeeService.getListByCompany(c.getId()));
		model.addAttribute("listDepartment", this.departmentService.getListByCompany(c.getId()));
		return "basicInfo/employees";
    }
	
}