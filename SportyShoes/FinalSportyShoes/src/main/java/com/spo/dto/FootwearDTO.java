package com.spo.dto;

public class FootwearDTO {

	private Long id;
	private String name;
	

	private int categoryId;
	private double price;
	private int size;
	private String Description;
	private String imageName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public FootwearDTO(Long id, String name, int categoryId, double price, int size, String description,
			String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.size = size;
		Description = description;
		this.imageName = imageName;
	}
	public FootwearDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FootwearDTO [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", price=" + price
				+ ", size=" + size + ", Description=" + Description + ", imageName=" + imageName + "]";
	}
	
	
}
