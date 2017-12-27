package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Inventory;

public interface InventoryService {

	public void save(Inventory p);
	public void update(Inventory p);
	public List<Inventory> getAll();
	public List<Inventory> getListByCompany(int company_id);
	public Inventory getById(int id);
	public void delete(int id);
	
}
