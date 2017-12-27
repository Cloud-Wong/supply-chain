package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Company;

public interface CompanyDao {
	
	public void save(Company c);
	public void update(Company c);
	public List<Company> getAll();
	public Company getById(int id);
	public void delete(int id);
	public boolean login(Company c);
}
