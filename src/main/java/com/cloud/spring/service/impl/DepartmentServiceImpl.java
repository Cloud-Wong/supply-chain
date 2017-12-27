package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.DepartmentDao;
import com.cloud.spring.model.Department;
import com.cloud.spring.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	@Transactional
	public void save(Department d) {
		this.departmentDao.save(d);
	}

	@Override
	@Transactional
	public void update(Department d) {
		this.departmentDao.update(d);
	}

	@Override
	@Transactional
	public List<Department> getAll() {
		return this.departmentDao.getAll();
	}

	@Override
	@Transactional
	public Department getById(int id) {
		return this.departmentDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.departmentDao.delete(id);
	}

	@Override
	@Transactional
	public List<Department> getListByCompany(int company_id) {
		return this.departmentDao.getByCompany(company_id);
	}

}
