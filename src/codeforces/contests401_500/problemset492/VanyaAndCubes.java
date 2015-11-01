package codeforces.contests401_500.problemset492;

import java.util.Scanner;

/**
 * Code forces - Problem 280 A
 */
public class VanyaAndCubes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(findPyramidHeight(n));
	}
	
	static int findPyramidHeight(int n) {
		int[] a = new int[1000];
		int[] sum = new int[1000];
		a[1] = 1;
		sum[1] = 1;
		for (int i = 2; i < 1000; i++) {
			a[i] = a[i - 1] + i;
			sum[i] = sum[i - 1] + a[i];
		}
		for (int i = 1;;i++) {
			if (n < sum[i]) {
				return i - 1;
			}
		}
	}	
	
}
