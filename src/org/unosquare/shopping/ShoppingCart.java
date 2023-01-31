package org.unosquare.shopping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ShoppingCart {
	// A global ShoppingList attribute
	// A Constructor that will initialize (fill) the ShoppingList
	
	// A HashSet that will store 
		// Store A product object name in CAPS
		// Can not store repeated products
		// It must only store elements that are already in the ShoppingList object. In the case it does not exist it must throw an exception.
		// A method to add elements into the set must be created. The parameters received by it should be String and Double.
		// A method to remove elements from the set.
		// A print method that will print Product: <<PRODUCT NAME>>[<<Price>>]
		// A calculateTaxes method that must calculate the taxes of the total cost for the list. Tax rate is 15%
		// A printTotal method that must show:
			// Subtotal:  $XX.XX 
			// Taxes: $XX.XX
			// TOTAL: $XX.XX
			// Where every $XX.XX is a Double value that must have 2 decimals.
		// All prices must be per unit. 
		// Subtotal value it's the sum of all products in the ShoppingCart, which means it must calculate the total by-product 
		//	(the result of multiplying the product quantity by the product unit price) for all products. In the end the subtotal value must be rounded to normal.
		// Taxes value is the result of calculateTaxes method and it must be rounded down.
		// TOTAL value must be the sum of Subtotal + Taxes and it must be rounded up.
	public HashMap<String, Double> shoppingCart = new HashMap<>();
	ShoppingList shoppingList = new ShoppingList();
	Map<String, Product> productMap = new HashMap<String, Product>();
	
	List<Double> prices = new ArrayList();
	
	
	public ShoppingList ShoppingCart(){
		// Constructor to fill the ShoppingList 
		shoppingList.addItem("One",1);
		shoppingList.addItem("Two",1);
		shoppingList.addItem("Three",1);
		shoppingList.printWholeHash();
		return shoppingList;
	}
	
	public void addToShoppingCart(String item, double price) {
		if(item != null) {
		item = item.toUpperCase();
		}else {
			throw new NullPointerException("Name of the item it's not admited");
		}
		if(shoppingList.verifyItem(item)) {
			shoppingCart.put(item, price);
			// X
			productMap.put(item, new Product(item, price));

			Product productPrice = (Product)productMap.get(item);
			prices.add(productPrice.getPrice());
			
			System.out.println("Successfully added item {" + item + "} with price [" + price + "]");
		}
	}
	
	public void deleteItem(String item) {
		// Exception 1 -> product does not exist in the hash
		// Exception 2 -> Empty string received = String must not be empty (this can be an if)
		// Exception 3 -> Receiving a 'null' should throw exception
		// Final -> print the amount of removed products
		try {
			
			if(item == null) 
				throw new NullPointerException("Item can't be null");
			
			if(item.toUpperCase().isEmpty() || item.toUpperCase().isBlank()) 
				throw new NullPointerException("Item can't be blank");

			item = item.toUpperCase();
			if(shoppingCart.get(item) == null) {
				throw new NullPointerException("Item is not present on the hash.");
			}
			
			System.out.println("Attempting to remove: " + item.toUpperCase());
			double price = shoppingCart.get(item);
			int ocurrences = Collections.frequency(prices, price);
			if(ocurrences == 1) {
				prices.remove(price);
				shoppingCart.remove(item);
			}else {
				if(ocurrences > 1) {
					prices.remove(price);
				}
			}
			
		}catch(NullPointerException e) {
			System.out.print("Catched NullPointerException: " + e + "\n");
		}
		catch(Exception e) {
			System.out.println("By any reason something went wrong with exception: " + e + "\n");
		}finally {
			System.out.println("End of remove process.");
			printWholeHash();
		}
	}
	
	/**
	 * Method to print the whole hash map
	 */
	public void printWholeHash() {
			try {
				System.out.println(shoppingCart.toString());
			}catch(Exception e) {
				System.out.println("Catching here");
			}
		}
	
	public void printProductMap() {
		try {
			System.out.println(productMap.toString());
			System.out.println("Product prices: ");
			System.out.println(prices);
		}catch(Exception e) {
			System.out.println("Catching here");
		}
	}
	
	public double calculateTotal() {
		double sum = 0;
		for(double value: prices) {
			sum += value;
			}
		System.out.println(String.format("%.2f",sum));
		return sum;
	}
	
	public double calculateTaxes() {
		double taxes = 0;
		double taxeRate = 10;
		taxes = (calculateTotal())*(taxeRate / 100);
		taxes = Math.floor(taxes);
		System.out.println("Taxe rate of [" + taxeRate + "] Total taxes:" + String.format("%.2f",taxes));
		return taxes;
	}
	
	public double calculateTotalWithTaxes() {
		double totalWithTaxes = 0;
		
		totalWithTaxes = calculateTotal() + calculateTaxes();
		totalWithTaxes = Math.ceil(totalWithTaxes);
		System.out.println("Total after taxes: " + String.format("%.2f",totalWithTaxes));
		return totalWithTaxes;
	}
	
	public void summaryPrint() {
		double subtotal = calculateTotal();
		double taxes = calculateTaxes();
		double total = calculateTotalWithTaxes();
		System.out.println("=========================================================");
		System.out.println("SubTotal: $" + subtotal);
		System.out.println("Taxes: $" + taxes);
		System.out.println("TOTAL: $" + total);
		System.out.println("=========================================================");
	}
	
	public static void main(String args[]){
		ShoppingCart sc = new ShoppingCart();
		ShoppingList shoppingList = sc.ShoppingCart();
		shoppingList.addItem("Shampoo",1);
		shoppingList.printWholeHash();
		
		sc.addToShoppingCart("One", 120.50);
		sc.printWholeHash();
		sc.addToShoppingCart("One", 120.50);
		sc.printWholeHash();
		sc.addToShoppingCart("Two", 100);
		sc.printWholeHash();
		sc.addToShoppingCart("Three", 200);
		sc.deleteItem("One");
		sc.deleteItem("One");
		sc.deleteItem("One");
		sc.addToShoppingCart("One", 120.50);
		sc.deleteItem("One");
		sc.deleteItem("One");
		sc.addToShoppingCart("One", 120.50);
		sc.addToShoppingCart("One", 120.50);
		sc.addToShoppingCart("One", 120.50);
		sc.addToShoppingCart("One", 120.50);
		sc.printWholeHash();
		sc.calculateTotal();
		sc.calculateTaxes();
		sc.calculateTotalWithTaxes();
		sc.printProductMap();
		sc.summaryPrint();
		
		/*
		Map<String, Product> productMap = new HashMap<String, Product>();
		productMap.put("asd", new Product("asd", 10));
		productMap.put("asd", new Product("asd", 10));
		productMap.put("asdssssss", new Product("hrtegrfw", 30));
		
		System.out.println(productMap);
		
		Product getAsd = (Product)productMap.get("asd");
		System.out.println(getAsd.getName());
		System.out.println(getAsd.getPrice());
		System.out.println(getAsd.name.toString());
		*/
	}
	}

