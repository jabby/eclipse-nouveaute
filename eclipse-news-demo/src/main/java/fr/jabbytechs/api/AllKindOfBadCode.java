package fr.jabbytechs.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllKindOfBadCode {

	public static String dateCheck= "\\d{4}-\\d{2}-\\d{2}";
	
	public static void main(String[] args) {

		// Regexp compile
		"2020-03-17".matches(dateCheck);
		"2020-03-17".replaceFirst(dateCheck, "0000-00-00");
		"2020-03-17".replaceAll(dateCheck, "0000-00-00");
		"A2020-03-17B".split(dateCheck);

		// Add elements in collections without loop
		List<String> inputList = Arrays.asList("Hello", "Devoxx");
		List<String> outputList  = new ArrayList<>();
		
		for (int i = 0; i < inputList.size(); i++) {
		    outputList.add(inputList.get(i));
		}
		

		// Java Features
		Object object = 1;
		int j = 0;
		if (object instanceof Integer) {
		    Integer i = (Integer) object;
		    j = i.intValue();
		}

		int i;
		switch(j) {
		    case 1:
		        i = 3;
		        break;
		    case 2:
		        i = 4;
		        break;
		    default:
		        i = 0;
		        break;
		}
		
		// valueOf
		Object characterObject = Character.valueOf('a');
		new Byte("0").byteValue();
		long l = new Long(42);
		
		// Create array with curly when possible
		double[] doubleArray = new double[] { 42.42 };

		
	}
	
	// Use StringBuilder instead of StringBuffer clean up
	public void foo(StringBuffer x) {
		StringBuffer y = new StringBuffer();
	    y.append("a string");
	    System.out.println(y.toString());
	}

}
