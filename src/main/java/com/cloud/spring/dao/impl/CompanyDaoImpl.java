package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.CompanyDao;
import com.cloud.spring.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Company d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		
	}

	@Override
	public void update(Company d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Company updated successfully, Company Details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Company> CompanyList = session.createQuery("from Company").list();
		for (Company d : CompanyList) {
			logger.info("Company List::" + d);
		}
		return CompanyList;
	}

	@Override
	public Company getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Company d = (Company) session.load(Company.class, new Integer(id));
		logger.info("Company loaded successfully, Company details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Company d = (Company) session.load(Company.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Company deleted successfully, Company details=" + d);
	}

	@Override
	public boolean login(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		Company d = (Company) session.get(Company.class, c.getId());
		if (null != d) {
			return true;
		}
		return false;
	}

}
