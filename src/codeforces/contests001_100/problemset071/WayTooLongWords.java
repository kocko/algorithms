package codeforces.contests001_100.problemset071;

import java.util.Scanner;

public class WayTooLongWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(replace(sc.next()));
		}
		sc.close();
	}
	
	static String replace(String x) {
		if (x.length() <= 10) {
			return x;
		}
		int l = x.length();
		return x.charAt(0) + String.valueOf(l - 2) + x.charAt(l - 1);
	}
	
}
