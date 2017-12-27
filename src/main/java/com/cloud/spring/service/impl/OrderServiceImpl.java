package com.cloud.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.spring.dao.OrderDao;
import com.cloud.spring.model.Order;
import com.cloud.spring.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public void save(Order d) {
		this.orderDao.save(d);
	}

	@Override
	@Transactional
	public void update(Order d) {
		this.orderDao.update(d);
	}

	@Override
	@Transactional
	public List<Order> getAll() {
		return this.orderDao.getAll();
	}

	@Override
	@Transactional
	public Order getById(int id) {
		return this.orderDao.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.orderDao.delete(id);
	}

	@Transactional
	@Override
	public List<Order> getByPCompany(int company_id) {
		return this.orderDao.getByPCompany(company_id);
	}

	@Transactional
	@Override
	public List<Order> getBySCompany(int company_id) {
		 return this.orderDao.getBySCompany(company_id);
	}

	@Transactional
	@Override
	public void confirmedOrder(int id) {
		this.orderDao.changeStatus(id, 1);	//确定订单
		
	}

	@Transactional
	@Override
	public void deliverGoods(int id) {
		this.orderDao.changeStatus(id, 2);	//发货
	}

	@Transactional
	@Override
	public void finishOrder(int id) {
		this.orderDao.changeStatus(id, 3);	//完成	
	}



}
