package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.CustomerDao;
import com.cloud.spring.model.Customer;
import com.cloud.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public void save(Customer d) {
		this.customerDao.save(d);
	}

	@Override
	@Transactional
	public void update(Customer d) {
		this.customerDao.update(d);
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return this.customerDao.getAll();
	}

	@Override
	@Transactional
	public Customer getById(int id) {
		return this.customerDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.customerDao.delete(id);
	}

	@Override
	@Transactional
	public List<Customer> getListByCompany(int compang_id) {
		return this.customerDao.getByCompany(compang_id);
	}

}
