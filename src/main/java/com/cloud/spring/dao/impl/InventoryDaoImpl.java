package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.InventoryDao;
import com.cloud.spring.model.Inventory;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryDaoImpl.class);

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(Inventory d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Inventory saved successfully, Inventory Details="+d);	
	}

	@Override
	public void update(Inventory d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Inventory updated successfully, Inventory Details="+d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Inventory> InventoryList = session.createQuery("from Inventory").list();
		for(Inventory d : InventoryList){
			logger.info("Inventory List::"+d);
		}
		return InventoryList;
	}

	@Override
	public Inventory getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Inventory d = (Inventory) session.load(Inventory.class, new Integer(id));
		logger.info("Inventory loaded successfully, Inventory details="+d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Inventory d = (Inventory) session.load(Inventory.class, new Integer(id));
		if(null != d){
			session.delete(d);
		}
		logger.info("Inventory deleted successfully, Inventory details="+d);	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Inventory> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Inventory> InventoryList = session.createQuery("from Inventory where company_id =" + company_id).list();
		for(Inventory d : InventoryList){
			logger.info("Inventory List::"+d);
		}
		return InventoryList;
	}

}
