package com.ap;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
	private int id;
	private String name;
	private String type;
	private BigDecimal price;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Product(int id, String name, String type, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	public ArrayList<Product> getProductDetails()
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		 
		productList.add(new Product(id, name, type, price));  
		 
		 for (Product s : productList) 
			{
				System.out.print("ID, Name, Color, and Price of the product are : ");
				System.out.println(s.id + " " + s.name + " " + s.type + " " + s.price);
			}
		return productList;
	}
	
	
}
