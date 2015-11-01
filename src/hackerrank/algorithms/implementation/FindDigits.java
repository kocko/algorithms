package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			long n = sc.nextLong();
			System.out.println(findDigits(n));
		}
		sc.close();
	}

	static int findDigits(long n) {
		int count = 0;
		char[] digits = (n + "").toCharArray();
		for (char digit : digits) {
			if (digit != '0') {
				if (n % (digit - '0') == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
