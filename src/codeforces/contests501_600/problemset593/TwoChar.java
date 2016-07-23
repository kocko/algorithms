package codeforces.contests501_600.problemset593;

import java.util.Scanner;

/**
 * Code forces - Problem 593 A
 */
public class TwoChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.nextLine();
		}
		System.out.println(maximizeArticle(words));
		sc.close();
	}
	
	static int maximizeArticle(String[] words) {
		int n = words.length;
		int result = 0;
		for (char c = 'a'; c <= 'y'; c++) {
			for (char d = (char) (c + 1); d <= 'z'; d++) {
				int temp = 0;
				for (int i = 0; i < n; i++) {
					temp += score(words[i], c, d);
				}
				if (temp > result) result = temp;
			}
		}
		return result;
	}
	
	static int score(String word, char a, char b) {
		char[] letters = word.toCharArray();
		for (char c : letters) {
			if (c != a && c != b) {
				return 0;
			}
		}
		return letters.length;
	}

}
