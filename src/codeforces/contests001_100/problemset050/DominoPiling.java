package codeforces.contests001_100.problemset050;

import java.util.Scanner;

public class DominoPiling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = (m * n) / 2;
		System.out.println(result);
		sc.close();
	}
}
