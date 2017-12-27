package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.ItemUpshelf;

public interface ItemUpshelfService {

	public void save(ItemUpshelf p);
	public void update(ItemUpshelf p);
	public List<ItemUpshelf> getAllPutaway();
	public List<ItemUpshelf> getSelfList(int id);	
	public ItemUpshelf getById(int id);
	public void delete(int id);
	public void changeStatus(int id);	
	
}
