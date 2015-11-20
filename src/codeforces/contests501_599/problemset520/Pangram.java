package codeforces.contests501_599.problemset520;

import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String word = sc.next();
		sc.close();
		if (n < 26) {
			System.out.println("NO");
			return;
		} else {
			System.out.println(isPangram(word) ? "YES" : "NO");
		}
	}

	static boolean isPangram(String word) {
		word = word.toLowerCase();
		boolean[] used = new boolean[26];
		for (char c : word.toCharArray()) {
			if (c >= 'a')
				used[c - 'a'] = true;
		}
		for (boolean b : used) {
			if (!b)
				return false;
		}
		return true;
	}
	
}
