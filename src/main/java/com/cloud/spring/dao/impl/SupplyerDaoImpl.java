package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.SupplyerDao;
import com.cloud.spring.model.Supplyer;

@Repository
public class SupplyerDaoImpl implements SupplyerDao {

	private static final Logger logger = LoggerFactory.getLogger(SupplyerDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Supplyer d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Supplyer saved successfully, Supplyer Details=" + d);
	}

	@Override
	public void update(Supplyer d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Supplyer updated successfully, Supplyer Details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplyer> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Supplyer> SupplyerList = session.createQuery("from Supplyer").list();
		for (Supplyer d : SupplyerList) {
			logger.info("Supplyer List::" + d);
		}
		return SupplyerList;
	}

	@Override
	public Supplyer getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Supplyer d = (Supplyer) session.load(Supplyer.class, new Integer(id));
		logger.info("Supplyer loaded successfully, Supplyer details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Supplyer d = (Supplyer) session.load(Supplyer.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Supplyer deleted successfully, Supplyer details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplyer> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Supplyer> supplyerList = session.createQuery("from Supplyer where company_id = " + company_id).list();
		return supplyerList;
	}

}
