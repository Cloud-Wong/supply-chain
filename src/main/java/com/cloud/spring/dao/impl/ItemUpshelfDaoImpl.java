package com.cloud.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.spring.dao.ItemUpshelfDao;
import com.cloud.spring.model.ItemUpshelf;

@Repository
public class ItemUpshelfDaoImpl implements ItemUpshelfDao {

	private static final Logger logger = LoggerFactory.getLogger(ItemUpshelfDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void save(ItemUpshelf d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("ItemUpshelf saved successfully, ItemUpshelf Details=" + d);
	}

	@Override
	public void update(ItemUpshelf d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("ItemUpshelf updated successfully, ItemUpshelf Details=" + d);
	}



	@Override
	public ItemUpshelf getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemUpshelf d = (ItemUpshelf) session.load(ItemUpshelf.class, new Integer(id));
		logger.info("ItemUpshelf loaded successfully, ItemUpshelf details=" + d);
		return d;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemUpshelf d = (ItemUpshelf) session.load(ItemUpshelf.class, new Integer(id));
		if (null != d) {
			session.delete(d);
		}
		logger.info("ItemUpshelf deleted successfully, ItemUpshelf details=" + d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemUpshelf> getAllPutaway() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ItemUpshelf> ItemUpshelfList = session.createQuery("from ItemUpshelf as itemUpshelf where itemUpshelf.status = 1").list();
		return ItemUpshelfList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemUpshelf> getSelfList(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ItemUpshelf> ItemUpshelfList = session.createQuery("from ItemUpshelf where company_id="+id).list();
		return ItemUpshelfList;
	}

	@Override
	public void changeStatus(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemUpshelf i = (ItemUpshelf)session.load(ItemUpshelf.class, new Integer(id));
		if(i.getStatus()==0){
			i.setStatus(1);
		}
		else{
			i.setStatus(0);
		}
		session.update(i);			
	}

}
