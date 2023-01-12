package com.unosquare.activityOne;
import java.util.ArrayList;

public class ExerciseOneMethods {
	
	/**
	 * Method to calculate % of 3. 
	 * @param value
	 * @return true if %3 == 0.
	 */
    public static Boolean canBeDividedBy3(Integer value) {
    	
        if (value % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Generate 'value' amount of numbers as an arrayList.
     * @param value
     * @return list of numbers.
     */
    public static ArrayList<Integer> generatedNumbers(Integer value){
    	
        ArrayList<Integer> list = new ArrayList<>();
        Integer i=1;

        while(value>=i){
            list.add(i);
            i++;
        }
        return list;
    }
}