package hackerrank.algorithms.sorting;

import java.util.Scanner;

public class InsertionSortPart1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		printInsertionSortSteps(array);
		sc.close();
	}
	
	static void printInsertionSortSteps(int[] array) {
		int n = array.length;
		int candidate = array[n - 1];
		int slot = 0;
		for (int i = 0; i < n - 1; i++) {
			if (array[i] <= candidate && candidate <= array[i + 1]) {
				slot = i + 1;
				break;
			}
		}
		for (int i = n - 1; i > slot; i--) {
			array[i] = array[i - 1];
			printArray(array);
		}
		array[slot] = candidate;
		printArray(array);
	}
	
	static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
