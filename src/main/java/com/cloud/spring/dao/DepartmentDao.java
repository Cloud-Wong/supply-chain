package com.cloud.spring.dao;

import java.util.List;
import com.cloud.spring.model.Department;

public interface DepartmentDao {
	
	public void save(Department d);
	public void update(Department d);
	public List<Department> getAll();
	public List<Department> getByCompany(int company_id);
	public Department getById(int id);
	public void delete(int id);
}
