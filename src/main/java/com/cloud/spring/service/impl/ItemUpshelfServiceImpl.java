package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.ItemUpshelfDao;
import com.cloud.spring.model.ItemUpshelf;
import com.cloud.spring.service.ItemUpshelfService;

@Service
public class ItemUpshelfServiceImpl implements ItemUpshelfService {
	
	private ItemUpshelfDao itemUpshelfDao;

	@Autowired
	public void setItemUpshelfDao(ItemUpshelfDao itemUpshelfDao) {
		this.itemUpshelfDao = itemUpshelfDao;
	}

	@Override
	@Transactional
	public void save(ItemUpshelf d) {
		this.itemUpshelfDao.save(d);
	}

	@Override
	@Transactional
	public void update(ItemUpshelf d) {
		this.itemUpshelfDao.update(d);
	}



	@Override
	@Transactional
	public ItemUpshelf getById(int id) {
		return this.itemUpshelfDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.itemUpshelfDao.delete(id);
	}
	
	@Transactional
	@Override
	public List<ItemUpshelf> getAllPutaway() {
	 return this.itemUpshelfDao.getAllPutaway();
	}

	@Transactional
	@Override
	public List<ItemUpshelf> getSelfList(int id) {
		return this.itemUpshelfDao.getSelfList(id);
	}

	@Transactional
	@Override
	public void changeStatus(int id) {
		this.itemUpshelfDao.changeStatus(id);	
	}



}
