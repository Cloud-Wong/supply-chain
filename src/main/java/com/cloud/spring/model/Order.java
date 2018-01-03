package com.cloud.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERFORM")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product pproduct; // 采购商品
	@OneToOne
	private Product sproduct; // 销售商品
	@ManyToOne
	private Company pcompany; // 采购公司
	@ManyToOne
	private Company scompany; // 销售公司
	private String adress; // 收获地址
	private String tel; // 联系方式
	private int status; // 0表示待确认 1表示待发货 2表示配送中 3表示已完成
	private int count;
	private int cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Product getPproduct() {
		return pproduct;
	}

	public void setPproduct(Product pproduct) {
		this.pproduct = pproduct;
	}

	public Product getSproduct() {
		return sproduct;
	}

	public void setSproduct(Product sproduct) {
		this.sproduct = sproduct;
	}

	public Company getPcompany() {
		return pcompany;
	}

	public void setPcompany(Company pcompany) {
		this.pcompany = pcompany;
	}

	public Company getScompany() {
		return scompany;
	}

	public void setScompany(Company scompany) {
		this.scompany = scompany;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Order() {
		super();
	}

}
