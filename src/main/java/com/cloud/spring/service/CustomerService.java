package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Customer;

public interface CustomerService {

	public void save(Customer p);
	public void update(Customer p);
	public List<Customer> getAll();
	public List<Customer> getListByCompany(int compang_id);
	public Customer getById(int id);
	public void delete(int id);
	
}
