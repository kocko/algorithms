package codeforces.contests101_200.problemset118;

import java.util.Scanner;

public class StringTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next().toLowerCase();
		for (char c : s.toCharArray()) {
			if (!isVowel(c)) {
				System.out.print("." + c);
			}
		}
		System.out.println();
		sc.close();
	}
	
	static boolean isVowel(char c) {
		return "aeouiy".indexOf(c) >= 0;
	}
	
}
