package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Company;

public interface CompanyService {

	public void save(Company p);
	public void update(Company p);
	public List<Company> getAll();
	public Company getById(int id);
	public void delete(int id);
	public boolean login(Company c);
	
}
