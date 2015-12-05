package codeforces.contests501_599.problemset520;

import java.util.Scanner;

public class TwoButtons {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		System.out.println(countButtonPresses(n, m));
	}

	static int countButtonPresses(int n, int m) {
		int count = 0;
		while (true) {
			if (m <= n) {
				count += (n - m);
				break;
			} else {
				if (m % 2 == 0) {
					m >>= 1;
				} else {
					m++;
				}
				count++;
			}
		}
		return count;
	}

}
