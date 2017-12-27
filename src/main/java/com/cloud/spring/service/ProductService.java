package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Product;

public interface ProductService {

	public void save(Product p);
	public void update(Product p);
	public List<Product> getAll();
	public List<Product> getListByCompany(int company_id);
	public Product getById(int id);
	public void delete(int id);
	
}
