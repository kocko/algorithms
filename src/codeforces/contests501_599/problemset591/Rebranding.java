package codeforces.contests501_599.problemset591;

import java.util.Scanner;

/**
 * Code forces - Problem 592 B
 */
public class Rebranding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split("\\s");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		String word = sc.nextLine();
		char[] map = new char['a' + 26];
		for (char c = 'a'; c <= 'z'; c++) {
			map[c] = c;
		}
		for (int i = 0; i < m; i++) {
			String[] chars = sc.nextLine().split("\\s");
			char[] design = { chars[0].charAt(0), chars[1].charAt(0) };
			if (design[0] != design[1]) {
				map[design[0]] = design[1];
				map[design[1]] = design[0];
			}
		}
		char[] logo = word.toCharArray();
		for (int i = 0; i < n; i++) {
			System.out.print(map[logo[i]]);
		}
		System.out.println();
		sc.close();
	}

}
