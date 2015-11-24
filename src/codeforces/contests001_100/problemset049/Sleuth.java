package codeforces.contests001_100.problemset049;

import java.util.Scanner;

public class Sleuth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] question = sc.nextLine().toLowerCase().toCharArray();
		sc.close();
		String vowels = "aeouyi";
		int n = question.length;
		for (int i = n - 1; i >= 0; i--) {
			char c = question[i];
			if (Character.isLetter(c)) {
				if (vowels.indexOf(c) >= 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				return;
			}
		}
	}

}
