package org.unosquare.shopping;

public class Product {
	// Product class should contain:
	String name = null;
	double price = 0;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
}
