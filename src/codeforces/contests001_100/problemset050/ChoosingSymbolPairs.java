package codeforces.contests001_100.problemset050;

import java.util.Scanner;

public class ChoosingSymbolPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		int[] letters = new int[26];
		int[] digits = new int[10];
		for (char c : word.toCharArray()) {
			if (Character.isLetter(c)) {
				letters[c - 'a']++;
			} else if (Character.isDigit(c)) {
				digits[c - '0']++;
			}
		}
		long result = 0l;
		for (long i : letters) {
			if (i > 0)
				result += i * i;
		}
		for (long i : digits) {
			if (i > 0)
				result += i * i;
		}
		System.out.println(result);
	}
	
}
