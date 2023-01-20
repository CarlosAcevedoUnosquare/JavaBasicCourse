package org.unosquare.shopping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to interact with ShoppingList methods class
 * Course: JAVA Basic
 * Title: Exceptions practice
 * URL of the activity:
 * https://courses.unosquare.com/moodle/mod/assign/view.php?id=1397
 * 
 * @author carlos.acevedo
 *
 */
public class ShoppingListExceptions {

	public static void main(String args[]){
	ShoppingList sl = new ShoppingList();
	
	
    sl.addItem("Shampoo",1); // total -> 1
    sl.print("Shampoo");
    sl.addItem("Shampoo",10); // total -> 11
    sl.print("Shampoo");
    sl.addItem("Shampoo",15); // total -> 26
    sl.print("Shampoo");
    sl.deleteItem("Shampoo"); // total -> null
    
    sl.addItem("Shampoo",10); // Adding item again with 10 units
    // Sending blank text as item
    sl.deleteItem("");
    
    //Sending null as item
    sl.deleteItem(null);
    
    //Sending non existent item to be deleted
    sl.deleteItem("NotExistentItem");
    
    sl.printWholeHash(); // should print {shampoo=10}
}
}
