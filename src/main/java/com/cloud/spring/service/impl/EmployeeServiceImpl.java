package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.EmployeeDAO;
import com.cloud.spring.model.Employee;
import com.cloud.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	@Autowired
	public void setPersonDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void save(Employee e) {
		this.employeeDAO.save(e);
	}

	@Override
	@Transactional
	public void update(Employee e) {
		this.employeeDAO.update(e);
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		return this.employeeDAO.getAll();
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		return this.employeeDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.employeeDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Employee> getListByCompany(int company_id) {
		return this.employeeDAO.getByCompany(company_id);
	}

}
