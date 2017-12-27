package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.SupplyerDao;
import com.cloud.spring.model.Supplyer;
import com.cloud.spring.service.SupplyerService;

@Service
public class SupplyerServiceImpl implements SupplyerService {
	
	private SupplyerDao supplyerDao;

	@Autowired
	public void setSupplyerDao(SupplyerDao supplyerDao) {
		this.supplyerDao = supplyerDao;
	}

	@Override
	@Transactional
	public void save(Supplyer d) {
		this.supplyerDao.save(d);
	}

	@Override
	@Transactional
	public void update(Supplyer d) {
		this.supplyerDao.update(d);
	}

	@Override
	@Transactional
	public List<Supplyer> getAll() {
		return this.supplyerDao.getAll();
	}

	@Override
	@Transactional
	public Supplyer getById(int id) {
		return this.supplyerDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.supplyerDao.delete(id);
	}

	@Override
	@Transactional
	public List<Supplyer> getListByCompany(int company_id) {
		return this.supplyerDao.getByCompany(company_id);
	}

}
