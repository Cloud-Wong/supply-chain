package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.Order;

public interface OrderDao {
	
	public void save(Order c);							//下单	
	public List<Order> getByPCompany(int company_id);	//查看采购订单
	public List<Order> getBySCompany(int company_id);	//查看销售订单
	public void changeStatus(int id,int status);		//确认订单(0-->1)、发货(1-->2)、完成(2-->3)
	public Order getById(int id);
	public void delete(int id);
	public void update(Order c);
	public List<Order> getAll();
}
