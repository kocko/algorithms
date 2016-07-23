package codeforces.contests601_700.problemset602;

import java.util.Scanner;

public class TwoBases {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long numbers[] = new long[2];
		for (int i = 0; i < 2; i++) {
			int n = sc.nextInt();
			int base = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int digit = sc.nextInt();
				numbers[i] = numbers[i] * base + digit; 
			}
		}
		if (numbers[0] > numbers[1]) System.out.println(">");
		if (numbers[0] < numbers[1]) System.out.println("<");
		if (numbers[0] == numbers[1]) System.out.println("=");
		sc.close();
	}
	
}
