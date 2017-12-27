package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.EmployeeDAO;
import com.cloud.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Employee saved successfully, Employee Details=" + e);
	}

	@Override
	public void update(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Employee updated successfully, Employee Details=" + e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> EmployeeList = session.createQuery("from Employee").list();
		for (Employee e : EmployeeList) {
			logger.info("Employee List::" + e);
		}
		return EmployeeList;
	}

	@Override
	public Employee getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Employee loaded successfully, Employee details=" + e);
		return e;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if (null != e) {
			session.delete(e);
		}
		logger.info("Employee deleted successfully, Employee details=" + e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee where company_id =" + company_id).list();
		return employeeList;
	}

}
