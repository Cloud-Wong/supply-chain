package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Supplyer;

public interface SupplyerDao {
	
	public void save(Supplyer s);
	public void update(Supplyer s);
	public List<Supplyer> getAll();
	public List<Supplyer> getByCompany(int company_id);
	public Supplyer getById(int id);
	public void delete(int id);
}
