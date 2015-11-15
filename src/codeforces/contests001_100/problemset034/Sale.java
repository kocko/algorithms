package codeforces.contests001_100.problemset034;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Code forces - Problem 34 B
 */
public class Sale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] money = new int[n];
		for (int i = 0; i < n; i++) {
			money[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(money);
		int result = 0; 
		for (int i = 0; i < m; i++) {
			if (money[i] <= 0) {
				result += money[i];
			}
		}
		System.out.println(result * (-1));
	}
	
}
