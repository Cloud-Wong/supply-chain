package com.cloud.spring.service;

import java.util.List;

import com.cloud.spring.model.Order;

public interface OrderService {

	public void save(Order c);							//下单	
	public List<Order> getByPCompany(int company_id);	//查看采购订单
	public List<Order> getBySCompany(int company_id);	//查看销售订单
	public void confirmedOrder(int id);		//确认订单(0-->1)
	public void deliverGoods(int id);		//发货(1-->2)
	public void finishOrder(int id);		//完成(2-->3)
	public Order getById(int id);
	public void delete(int id);
	public void update(Order c);
	public List<Order> getAll();
	
}
