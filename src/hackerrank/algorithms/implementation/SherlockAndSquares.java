package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class SherlockAndSquares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(countSquaresBetween(a, b));
		}
		sc.close();
	}
	
	static int countSquaresBetween(int a, int b) {
		double floor = Math.ceil(Math.sqrt(a));
		double ceil = Math.floor(Math.sqrt(b));
		return (int) (ceil - floor + 1);
	}
	
}
