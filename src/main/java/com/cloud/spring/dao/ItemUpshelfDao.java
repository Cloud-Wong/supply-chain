package com.cloud.spring.dao;

import java.util.List;

import com.cloud.spring.model.ItemUpshelf;

public interface ItemUpshelfDao {
	
	public void save(ItemUpshelf c);					//增加货架信息
	public void update(ItemUpshelf c);					//修改货架信息
	public List<ItemUpshelf> getAllPutaway();			//显示所有上架的货架信息  where status=1
	public List<ItemUpshelf> getSelfList(int id);		//获取本公司所有货架信息	 where company.id=id
	public ItemUpshelf getById(int id);		//显示货架详细信息
	public void delete(int id);				//删除货架
	public void changeStatus(int id);		//上下架切换
}
