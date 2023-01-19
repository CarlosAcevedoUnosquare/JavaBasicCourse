package org.unosquare.shopping;

/**
 * Class to interact with ShoppingList methods class
 * Course: JAVA Basic
 * URL of the activity:
 * https://courses.unosquare.com/moodle/mod/assign/view.php?id=1392
 * 
 * @author carlos.acevedo
 *
 */
public class ShoppingListMain {

	public static void main(String args[]){
	ShoppingList sl = new ShoppingList();
	
	
    sl.addItem("Shampoo",1); // total -> 1
    sl.print("Shampoo");
    sl.addItem("Shampoo",10); // total -> 11
    sl.print("Shampoo");
    sl.addItem("Shampoo",15); // total -> 26
    sl.print("Shampoo");
    
    
    sl.addItem("Soap",2); // total -> 2
    sl.print("Soap");
    sl.addItem("Soap",20); // total -> 22
    sl.print("Soap");
    sl.addItem("Soap",25); // total -> 47
    sl.print("Soap");
    
    
    sl.addItem("Tooth brush",3); // total -> 3
    sl.print("Tooth brush");
    sl.addItem("Tooth brush",30); // total -> 33
    sl.print("Tooth brush");
    sl.addItem("Tooth brush",33); // total 66
    sl.print("Tooth brush");
    
    //Printing totals
    sl.print("Shampoo");
    sl.print("Soap");
    sl.print("Tooth brush");
	
    sl.printWholeHash();
}
}
