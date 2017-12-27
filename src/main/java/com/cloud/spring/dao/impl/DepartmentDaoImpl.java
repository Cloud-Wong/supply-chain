package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.DepartmentDao;
import com.cloud.spring.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Department d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Department saved successfully, Department Details=" + d);
	}

	@Override
	public void update(Department d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Department updated successfully, Department Details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> DepartmentList = session.createQuery("from Department").list();
		for (Department d : DepartmentList) {
			logger.info("Department List::" + d);
		}
		return DepartmentList;
	}

	@Override
	public Department getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department d = (Department) session.load(Department.class, new Integer(id));
		logger.info("Department loaded successfully, Department details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department d = (Department) session.load(Department.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Department deleted successfully, Department details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> departmentList = session.createQuery("from Department where company_id =" + company_id).list();
		return departmentList;
	}

}
