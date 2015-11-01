package hackerrank.contests.codewhiz;

import java.lang.reflect.Method;

public class Solution {
	
	static class Printer {
		void printArray(Object[] array) {
			if (array instanceof String[]) {
				String[] a = (String[]) array;
				for (String t : a) {
					System.out.println(t);
				}
			}
			if (array instanceof Integer[]) {
				Integer[] a = (Integer[]) array;
				for (Integer t : a) {
					System.out.println(t);
				}
			}
		}
	}

	public static void main(String args[]) {
		Printer myPrinter = new Printer();
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		int count = 0;
		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();
			if (name.equals("printArray"))
				count++;
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");
		assert count == 1;

	}
}
