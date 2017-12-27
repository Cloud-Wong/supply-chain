package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.ProductDao;
import com.cloud.spring.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(Product d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Product saved successfully, Product Details="+d);	
	}

	@Override
	public void update(Product d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Product updated successfully, Product Details="+d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> ProductList = session.createQuery("from Product").list();
		for(Product d : ProductList){
			logger.info("Product List::"+d);
		}
		return ProductList;
	}

	@Override
	public Product getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product d = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details="+d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product d = (Product) session.load(Product.class, new Integer(id));
		if(null != d){
			session.delete(d);
		}
		logger.info("Product deleted successfully, Product details="+d);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getByCompany(int company_id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createQuery("from Product where company_id =" + company_id).list();
		return productList;
	}

}
