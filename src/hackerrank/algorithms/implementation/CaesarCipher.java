package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String input = sc.nextLine().trim();
		int k = Integer.parseInt(sc.nextLine().trim());
		k %= 26;
		sc.close();
		char[] result = new char[input.length()];
		int next = 0;
		for (char c : input.toCharArray()) {
			if ((c >= 'a' && c <= 'z')) {
				char candidate = (char) ((int) c + k);
				if (candidate > 'z') {
					candidate -= 'z' - 'a' + 1 ;
				}
				result[next++] = candidate;
			} else if (c >= 'A' && c <= 'Z') {
				char candidate = (char) ((int) c + k);
				if (candidate > 'Z') {
					candidate -= 'Z' - 'A' + 1 ;
				}
				result[next++] = candidate;
			} else {
				result[next++] = c;
			}
		}
		System.out.println(new String(result));
	}
}
