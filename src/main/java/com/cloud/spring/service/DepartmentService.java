package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Department;

public interface DepartmentService {

	public void save(Department p);
	public void update(Department p);
	public List<Department> getAll();
	public List<Department> getListByCompany(int company_id);
	public Department getById(int id);
	public void delete(int id);
	
}
