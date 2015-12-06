package codeforces.contests101_200.problemset158;

import java.util.Scanner;

public class Taxi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		int[] count = new int[5];
		for (int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}
		result += count[4];
		result += count[2] / 2;
		count[2] %= 2;
		if (count[2] != 0) {
			if (count[1] >= 2) {
				count[2] = 0;
				count[1] -= 2;
			} else if (count[1] == 1) {
				count[2] = 0;
				count[1] = 0;
			}
			result++;
		}
		int m = Math.min(count[1], count[3]);
		result += m;
		count[1] -= m;
		count[3] -= m;
		if (count[1] > 0) {
			int mod = count[1] % 4;
			count[1] -= mod;
			if (mod > 0) { 
				result++;
			}
			result += count[1] / 4;
		}
		if (count[3] > 0) {
			result += count[3];
		}
		System.out.println(result);
		sc.close();
	}
}
