package org.unosquare.shopping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {
	
	// add <<PRODUCT>> <<QUANTITY>> must add a product into the ShoppingList, like: "add Shampoo 1"
	// buy <<PRODUCT>> <<PRICE>>  must add a product into the ShoppingCart, like: "buy Shampoo 10.2334"
	// remove <<PRODUCT>> must remove a product into the ShoppingList, like: "remove Shampoo"
	// return <<PRODUCT>> must remove a product into the ShoppingCart, like: "return Shampoo"
	// total must called the printTotal method from the ShoppingCart


	
	public static void main(String args[]) throws IOException{
		ShoppingList sl = new ShoppingList();
		ShoppingCart sc = new ShoppingCart();
		ShoppingList shoppingList = sc.ShoppingCart();
		
		sc.addToShoppingCart("ItemTwo", 200);
		
		//Method to add to list
		shoppingList.addItem("ItemOne", 1);
		shoppingList.addItem("ItemTwo", 1);
		shoppingList.addItem("ItemOne", 1);
		
		shoppingList.deleteItem("ItemOne");
		
		
		//Method to add to cart
		sc.addToShoppingCart("ItemTwo", 200);
	
	
		//Method to print recipe
		sc.summaryPrint();
	
		//Remove from cart
		sc.returnProduct("ItemTwo");
		sc.summaryPrint();
	
		//Filling the shopping list using .txt document
		File path = new File("src/org/unosquare/shopping/list.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String line = reader.readLine();
		String fileProduct = null;
		int amount = 0;
		while(line != null) {
			System.out.println(line);
			String halfLine[] = line.split(" ", 2);
			fileProduct = halfLine[0];
			amount = Integer.parseInt(halfLine[1]);
	//		System.out.println("Item: [" + fileProduct + "]");
	//		System.out.println("Amount: [" + amount + "]");
			shoppingList.addItem(fileProduct, amount);
	//		shoppingList.printWholeHash();
			line = reader.readLine();
		}
		System.out.println("Done adding products into list.");
		shoppingList.printWholeHash();
		
		sc.addToShoppingCart("Something", 200);
		sc.addToShoppingCart("Another", 300);
		sc.summaryPrint();
		
		sc.returnProduct("Something");
		sc.returnProduct("Another");
		sc.summaryPrint();
		
		
		/*
		System.out.println("---------------------------------------");
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		boolean loop = true;
		try {
		while(loop) {
			System.out.println("What do you want to do?");
			System.out.println("1.- Add product to ShoppingList");
			System.out.println("2.- Delete product from shoopping list");
			System.out.println("3.- Add product to cart");
			System.out.println("4.- Delete product to cart");
			System.out.println("5.- Print whole shopping list");
			System.out.println("6.- Print ticket");
			System.out.println("7.- Exit");
			String selection = scanner.nextLine();
			try {
			option = Integer.parseInt(selection);
			}catch(Exception e) {
				option = 0;
			}
			switch(option) {
			case 1:
				System.out.println("Please add product using following logic: Product [space] quantity");
				line = scanner.nextLine();
				String halfLine[] = line.split(" ", 2);
				fileProduct = halfLine[0];
				amount = Integer.parseInt(halfLine[1]);
				shoppingList.addItem(fileProduct, amount);
				break;
			case 2:
				System.out.println("Please add product using following logic: Product name");
				selection = scanner.nextLine();
				shoppingList.deleteItem(selection);
				break;
			case 3:
				System.out.println("Please add product using following logic: Product name [space] price");
				line = scanner.nextLine();
				String halfLine3[] = line.split(" ", 2);
				fileProduct = halfLine3[0];
				double amountdouble = Double.parseDouble(halfLine3[1]);
				sc.addToShoppingCart(fileProduct, amountdouble);
				break;
			case 4:
				System.out.println("Please add product to be deleted using following logic: Product name");
				selection = scanner.nextLine();
				sc.returnProduct(selection);
				sc.summaryPrint();
				break;
			case 5:
				shoppingList.printWholeHash();
				break;
			case 6:
				sc.summaryPrint();
				break;
			case 7:
				loop = false;
				break;
			default:
				System.out.println("Not a valid option, please select a valid option.");
				break;
			}
		
		}
		}catch (Exception e) {
			System.out.println("Something went wrong, throwing: " + e);
		}
		*/
	}
}
