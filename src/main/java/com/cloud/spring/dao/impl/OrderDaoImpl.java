package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.OrderDao;
import com.cloud.spring.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Order d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Order saved successfully, Order Details=" + d);
	}

	@Override
	public void update(Order d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> OrderList = session.createQuery("from Order").list();
		for (Order d : OrderList) {
			logger.info("Order List::" + d);
		}
		return OrderList;
	}

	@Override
	public Order getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order d = (Order) session.load(Order.class, new Integer(id));
		logger.info("Order loaded successfully, Order details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order d = (Order) session.load(Order.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Order deleted successfully, Order details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getByPCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order where pcompany_id=" + company_id).list();
		return orderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getBySCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order where scompany_id=" + company_id).list();
		return orderList;
	}

	@Override
	public void changeStatus(int id, int status) {
		Session session = this.sessionFactory.getCurrentSession();
		Order o = (Order) session.load(Order.class, new Integer(id));
		o.setStatus(status);
		session.update(o);	
	}

}
