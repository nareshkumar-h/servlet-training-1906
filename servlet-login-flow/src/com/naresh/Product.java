package com.naresh;

public class Product {

	private String name;
	private Integer quanity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuanity() {
		return quanity;
	}
	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", quanity=" + quanity + "]";
	}
	
}
