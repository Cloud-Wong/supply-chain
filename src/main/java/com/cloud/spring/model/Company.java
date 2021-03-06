package com.cloud.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String adress;
	private String tel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Company() {
		super();
	}

	public Company(int id, String name, String adress, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", adress=" + adress + ", tel=" + tel + "]";
	}

}
