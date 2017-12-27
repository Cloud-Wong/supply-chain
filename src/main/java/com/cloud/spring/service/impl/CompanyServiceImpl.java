package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.CompanyDao;
import com.cloud.spring.model.Company;
import com.cloud.spring.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private CompanyDao companyDao;

	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	@Transactional
	public void save(Company d) {
		this.companyDao.save(d);
	}

	@Override
	@Transactional
	public void update(Company d) {
		this.companyDao.update(d);
	}

	@Override
	@Transactional
	public List<Company> getAll() {
		return this.companyDao.getAll();
	}

	@Override
	@Transactional
	public Company getById(int id) {
		return this.companyDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.companyDao.delete(id);
	}

	@Override
	@Transactional
	public boolean login(Company c) {
		return this.companyDao.login(c);
	}

}
