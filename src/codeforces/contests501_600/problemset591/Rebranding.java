package codeforces.contests501_600.problemset591;

import java.util.Scanner;

public class Rebranding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String word = sc.next();
		char[] map = new char[26];
		int i = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			map[i++] = c;
		}
		for (i = 0; i < m; i++) {
			char[] design = { sc.next().charAt(0), sc.next().charAt(0) };
			if (design[0] != design[1]) {
				int switched = 0;
				for (int j = 0; j < 26; j++) {
					if (switched == 2)
						break;
					if (map[j] == design[0]) {
						map[j] = design[1];
						switched++;
					} else if (map[j] == design[1]) {
						map[j] = design[0];
						switched++;
					}
				}
			}
		}
		for (i = 0; i < n; i++) {
			System.out.print(map[word.charAt(i) - 'a']);
		}
		System.out.println();
		sc.close();
	}

}
