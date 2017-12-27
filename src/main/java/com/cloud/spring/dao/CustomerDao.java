package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Customer;

public interface CustomerDao {
	
	public void save(Customer c);
	public void update(Customer c);
	public List<Customer> getAll();
	public List<Customer> getByCompany(int company_id);
	public Customer getById(int id);
	public void delete(int id);
}
