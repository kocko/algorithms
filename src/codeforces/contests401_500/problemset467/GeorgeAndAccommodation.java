package codeforces.contests401_500.problemset467;

import java.util.Scanner;

public class GeorgeAndAccommodation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (b - a >= 2)
				result++;
		}
		System.out.println(result);
		sc.close();
	}

}
