package org.unosquare.shopping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainSwitch {
	
	public void firstSwitch() {
		ShoppingList sl = new ShoppingList();
		ShoppingCart sc = new ShoppingCart();
		ShoppingList shoppingList = sc.ShoppingCart();
		
		System.out.println("---------------------------------------");
		String fileProduct = null;
		int amount = 0;
		String line = null;
		Scanner scanner = new Scanner(System.in);
		String option = null;
		boolean loop = true;
		try {
			System.out.println("What do you want to do?");
			System.out.println("Use the following commands to interact with the switch:");
			System.out.println("To Add a product: [Add] [product] [quantity]");
			System.out.println("To Buy a product: [Buy] [product] [price]");
			System.out.println("To Remove product: [Remove] [product]");
			System.out.println("To Return product: [Return] [product]");
			System.out.println("5.- Print whole shopping list");
			System.out.println("6.- Print ticket");
			System.out.println("7.- Exit");
		while(loop) {
			String selection = scanner.nextLine();
			try {
			// [Command] + [Product] + [####]
			String thirdLine[] = selection.split(" ", 3);
			// -> thirdLine[0] -> Command
			// -> thirdLine[1] -> Product
			// -> thirdLine[2] -> quantity/price  ------> this is not required
			
			option = thirdLine[0].toUpperCase();
			}catch(Exception e) {
				option = null;
			}
			switch(option) {
			case "ADD":
				try {
				String thirdLineAdd[] = selection.split(" ", 3);
				fileProduct = thirdLineAdd[1];
				amount = Integer.parseInt(thirdLineAdd[2]);
				shoppingList.addItem(fileProduct, amount);
				}catch(Exception e) {
					System.out.println("Something went wrong on the adding process, please try again");
				}
				break;
			case "BUY":
				try {
				String thirdLineBuy[] = selection.split(" ", 3);
				fileProduct = thirdLineBuy[1];
				double amountdouble = Double.parseDouble(thirdLineBuy[2]);
				sc.addToShoppingCart(fileProduct, amountdouble);
				}catch(Exception e) {
					System.out.println("Something went wrong at the buying process, please try again");
				}
				break;
			case "REMOVE":
				try {
				String thirdLineRemove[] = selection.split(" ", 3);
				String itemToBeDeleted = thirdLineRemove[1];
				shoppingList.deleteItem(itemToBeDeleted);
				}catch(Exception e) {
					System.out.println("Something went wrong at the remove process, please try again");
				}
				break;
			case "RETURN":
				try {
				String thirdLineReturn[] = selection.split(" ", 3);
				String itemToBeReturned = thirdLineReturn[1];
				sc.returnProduct(itemToBeReturned);
				sc.summaryPrint();
				}catch(Exception e) {
					System.out.println("Something went wrong at the return process, please try again");
				}
				break;
			case "5":
				shoppingList.printWholeHash();
				break;
			case "6":
				sc.summaryPrint();
				break;
			case "7":
				loop = false;
				break;
			default:
				System.out.println("Not a valid option, please select a valid option.");
				break;
			}
		}
		System.out.println("End of process.");
		System.out.println("Printing ticket . . .");
		sc.summaryPrint();
		}catch (Exception e) {
			System.out.println("Something went wrong, throwing: " + e);
		}
	}
	
	public void secondSwitch() {
		ShoppingList sl = new ShoppingList();
		ShoppingCart sc = new ShoppingCart();
		ShoppingList shoppingList = sc.ShoppingCart();
		
		System.out.println("---------------------------------------");
		String fileProduct = null;
		int amount = 0;
		String line = null;
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
	}

	public static void main(String args[]) throws IOException{
		MainSwitch main = new MainSwitch();
		
		main.firstSwitch();
//		main.secondSwitch();
	}
}