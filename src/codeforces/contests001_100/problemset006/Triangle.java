package codeforces.contests001_100.problemset006;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(find(new int[] { a, b, c, d }));
		sc.close();
	}

	static String find(int[] lines) {
		String result = null;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				for (int k = j + 1; k < 4; k++) {
					if (isTriangle(lines[i], lines[j], lines[k])) {
						return "TRIANGLE";
					} else if (isSegment(lines[i], lines[j], lines[k])) {
						result = "SEGMENT";
					}
				}
			}
		}
		return result == null ? "IMPOSSIBLE" : result;
	}

	static boolean isTriangle(int a, int b, int c) {
		return a + b > c && a + c > b && b + c > a;
	}

	static boolean isSegment(int a, int b, int c) {
		return a + b == c || a + c == b || b + c == a;
	}
}
