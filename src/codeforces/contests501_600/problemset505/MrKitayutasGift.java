package codeforces.contests501_600.problemset505;

import java.util.Scanner;

public class MrKitayutasGift {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		System.out.println(constructPalindrome(word));
		sc.close();
	}
	
	static String constructPalindrome(String word) {
		int n = word.length();
		for (int i = 0; i <= n; i++) {
			char[] c = new char[n + 1];
			int next = 0;
			for (int j = 0; j <= n; j++) {
				if (i != j) {
					c[j] = word.charAt(next++);
				} else {
					c[j] = '_';
				}
			}
			for (int j = 0; j <= n; j++) {
				if (c[j] == '_') {
					c[j] = c[n - j];
					break;
				}
			}
			if (isPalindrome(c)) {
				return new String(c);
			}
		}
		return "NA";
	}
	
	static boolean isPalindrome(char[] c) {
		int n = c.length;
		for (int i = 0; i < n/2; i++) {
			if (c[i] != c[n - i - 1]) return false;
		}
		return true;
	}
	
}
