package codeforces.contests501_599.problemset598;

import java.util.Scanner;

public class QueriesOnAString {

	static char[] word;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		word = input.toCharArray();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			applyQuery(l, r, k);
		}
		for (char c : word) {
			System.out.print(c);
		}
		System.out.println();
		sc.close();
	}

	static void applyQuery(int l, int r, int k) {
		int size = r - l + 1;
		char[] copy = new char[size];
		for (int i = 0; i < size; i++) {
			copy[i] = word[i + l - 1];
		}

		k %= size;

		int startFrom = size - k;
		if (startFrom > 0) {
			int j = l - 1;
			for (int i = startFrom; i < size; i++, j++) {
				word[j] = copy[i];
			}
			for (int i = 0; i < startFrom; i++, j++) {
				word[j] = copy[i];
			}
		}
	}

}

