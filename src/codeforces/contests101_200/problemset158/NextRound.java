package codeforces.contests101_200.problemset158;

import java.util.Scanner;

public class NextRound {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (score[i] >= score[k - 1] && score[i] > 0) result++;
		}
		System.out.println(result);
		sc.close();
	}
}
