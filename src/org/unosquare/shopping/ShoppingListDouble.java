package org.unosquare.shopping;

import java.util.HashMap;

public class ShoppingListDouble {

	public ShoppingListDouble() {
		
	}
	public HashMap<String, Double> shoppingList = new HashMap<>();
	
	//Store the product name in CAPS (toUpperCase)
	//Can't repeat products
	//In case of repeated value, quantity will be quantity = quantity + new quantity
	
	/**
	 * Method to add elements into ShoppingList hashmap
	 * In case any duplicated value, 'quantity' variable will be updated
	 * @param itemHere
	 * @param quantity
	 */
	public void addItem(String itemHere, double quantity) {
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
	
	double quantity;
	@SuppressWarnings("unused")
	public void deleteItem(String item) {
		quantity = 0;
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
			
			System.out.println("Attempting to remove: " + item.toUpperCase());
			System.out.println("Before: ["+item.toUpperCase()+"] -> " + shoppingList.get(item.toUpperCase()));
			
			quantity = shoppingList.remove(item.toUpperCase());
			shoppingList.remove(item);
			
			System.out.println("After: ["+item.toUpperCase()+"] -> " + shoppingList.get(item.toUpperCase()));
			
			printWholeHash();
			
		}catch(NullPointerException e) {
			System.out.print("Catched NullPointerException: " + e + "\n");
		}
		catch(Exception e) {
			System.out.println("By any reason something went wrong with exception: " + e + "\n");
		}finally {
			System.out.println("Amount of items removed: [" + quantity + "]");
		}
	}
	
}
