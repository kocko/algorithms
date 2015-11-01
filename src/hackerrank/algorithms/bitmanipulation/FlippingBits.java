package hackerrank.algorithms.bitmanipulation;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			long n = sc.nextLong();
			System.out.println(flipBits(n));
		}
		sc.close();
	}
	
	static long flipBits(long n) {
		String binary = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');
		char[] result = new char[32];
		int next = 0;
		for (char c : binary.toCharArray()) {
			if (c == '0') result[next] = '1';
			else if (c == '1') result[next] = '0';
			next++;
		}
		
		return Long.parseLong(new String(result), 2);
	}

}
