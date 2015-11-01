package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			int total = n / c;
			int wrappers = total;
			while (true) {
				if (wrappers >= m) {
					wrappers -= m;
					total++;
					wrappers++;
				} else {
					break;
				}
			}
			System.out.println(total);
		}
		sc.close();
	}

}
