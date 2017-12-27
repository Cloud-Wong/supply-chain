package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Employee;

public interface EmployeeService {

	public void save(Employee p);
	public void update(Employee p);
	public List<Employee> getAll();
	public List<Employee> getListByCompany(int company_id);
	public Employee getById(int id);
	public void delete(int id);
	
}
