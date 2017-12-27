package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Employee;

public interface EmployeeDAO {
    
	public void save(Employee p);
	public void update(Employee p);
	public List<Employee> getAll();
	public List<Employee> getByCompany(int company_id);
	public Employee getById(int id);
	public void delete(int id);
}
