package org.unosquare.shopping;

import java.util.HashMap;

public class ShoppingList {

	
	public ShoppingList() {
		
	}
	public HashMap<String, Integer> shoppingList = new HashMap<>();
	
	//Store the product name in CAPS (toUpperCase)
	//Can't repeat products
	//In case of repeated value, quantity will be quantity = quantity + new quantity
	
	/**
	 * Method to add elements into ShoppingList hashmap
	 * In case any duplicated value, 'quantity' variable will be updated
	 * @param itemHere
	 * @param quantity
	 */
	public void addItem(String itemHere, int quantity) {
		String item = itemHere.toUpperCase();
		if(item != null) {
			System.out.println("Adding item {"+item+"} to the hasmap");
			if(shoppingList.get(item) != null) {
				shoppingList.put(item, shoppingList.get(item) + quantity);
			}else {
				shoppingList.put(item, quantity);
			}
		}else {
			System.out.println("Error, either of the values for item or quantity it's not allowed");
		}
	}
	
	/**
	 * Method to print the current map at desired position
	 * NOTE: This method doesn't print the whole hash to avoid much text in console
	 * @param item
	 */
	public void print(String item) {
		//<<PRODUCT NAME>>[<<Quantity>>].
		if(shoppingList.get(item.toUpperCase()) != null && item != null) {
			try {
				System.out.println("Printing list at ["+item.toUpperCase()+"] -> " + shoppingList.get(item.toUpperCase()));
			}catch(Exception e) {
				System.out.println("Catching here");
			}
		}
	}
	
	/**
	 * Method to print the whole hash map
	 */
	public void printWholeHash() {
			try {
				System.out.println(shoppingList.toString());
			}catch(Exception e) {
				System.out.println("Catching here");
			}
		}
	}

