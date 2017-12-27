package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Supplyer;

public interface SupplyerService {

	public void save(Supplyer p);
	public void update(Supplyer p);
	public List<Supplyer> getAll();
	public List<Supplyer> getListByCompany(int company_id);
	public Supplyer getById(int id);
	public void delete(int id);
	
}
