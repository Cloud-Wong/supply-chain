package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.CustomerDao;
import com.cloud.spring.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Customer d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Customer saved successfully, Customer Details=" + d);
	}

	@Override
	public void update(Customer d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Customer updated successfully, Customer Details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> CustomerList = session.createQuery("from Customer").list();
		for (Customer d : CustomerList) {
			logger.info("Customer List::" + d);
		}
		return CustomerList;
	}

	@Override
	public Customer getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer d = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Customer loaded successfully, Customer details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer d = (Customer) session.load(Customer.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Customer deleted successfully, Customer details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer where company_id =" + company_id).list();
		return customerList;
	}

}
