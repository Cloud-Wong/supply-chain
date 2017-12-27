package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.InventoryDao;
import com.cloud.spring.model.Inventory;
import com.cloud.spring.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	private InventoryDao inventoryDao;

	@Autowired
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	@Override
	@Transactional
	public void save(Inventory d) {
		this.inventoryDao.save(d);
	}

	@Override
	@Transactional
	public void update(Inventory d) {
		this.inventoryDao.update(d);
	}

	@Override
	@Transactional
	public List<Inventory> getAll() {
		return this.inventoryDao.getAll();
	}

	@Override
	@Transactional
	public Inventory getById(int id) {
		return this.inventoryDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.inventoryDao.delete(id);
	}

	@Override
	@Transactional
	public List<Inventory> getListByCompany(int company_id) {
		return this.inventoryDao.getByCompany(company_id);
	}

}
