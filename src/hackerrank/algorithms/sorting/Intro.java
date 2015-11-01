package hackerrank.algorithms.sorting;

import java.util.Scanner;

public class Intro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] array = new int[m];
		for (int i = 0; i < m; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		int index = findIndexOfN(array, n);
		System.out.println(index);
	}
	
	static int findIndexOfN(int[] array, int n) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
}
