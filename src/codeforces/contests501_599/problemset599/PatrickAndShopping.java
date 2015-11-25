package codeforces.contests501_599.problemset599;

import java.util.Scanner;

public class PatrickAndShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d1 = sc.nextInt(), d2 = sc.nextInt(), d3 = sc.nextInt();
		int x = d1 + d2 + d3;
		int y = 2 * (d1 + d2);
		int z = 2 * (d1 + d3);
		int t = 2 * (d2 + d3);
		System.out.println(Math.min(Math.min(x, y), Math.min(z, t)));
		sc.close();
	}
	
}
