package com.hib;

import java.math.BigDecimal;

import javax.persistence.Entity;
@Entity

public class Product {
	 private int id;
	 private String name;
	 private BigDecimal price;
	 private String Company;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Product(int id, String name, BigDecimal price, String company) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		Company = company;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, BigDecimal price, String company) {
		super();
		this.name = name;
		this.price = price;
		Company = company;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", Company=" + Company + "]";
	}

	 
}
