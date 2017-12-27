package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.ProductDao;
import com.cloud.spring.model.Product;
import com.cloud.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public void save(Product d) {
		this.productDao.save(d);
	}

	@Override
	@Transactional
	public void update(Product d) {
		this.productDao.update(d);
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		return this.productDao.getAll();
	}

	@Override
	@Transactional
	public Product getById(int id) {
		return this.productDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.productDao.delete(id);
	}

	@Override
	@Transactional
	public List<Product> getListByCompany(int company_id) {
		return this.productDao.getByCompany(company_id);
	}

}
