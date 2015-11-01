package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class SherlockAndTheBeast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			System.out.println(findLargestDecentNumber(n));
		}
		sc.close();
	}

	static String findLargestDecentNumber(int n) {
		char[] digits = new char[n];
		int remainder = n % 3;
		int k = 0;
		int limit = n;
		while (true) {
			limit = n - (3 * k + remainder);
			if (limit < 0) {
				return "-1";
			}
			if ((n - limit) % 5 == 0) {
				break;
			}
			k++;
		}
		for (int i = 0; i < n; i++) {
			digits[i] = i < limit ? '5' : '3';
		}
		return new String(digits);
	}

}
