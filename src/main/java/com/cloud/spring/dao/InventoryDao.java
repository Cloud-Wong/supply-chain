package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Inventory;

public interface InventoryDao {
	
	public void save(Inventory c);
	public void update(Inventory c);
	public List<Inventory> getAll();
	public List<Inventory> getByCompany(int company_id);
	public Inventory getById(int id);
	public void delete(int id);
}
