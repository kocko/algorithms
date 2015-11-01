package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class XaeroAndABinaryGift {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		System.out.println(countSwaps(x, y));
		sc.close();
	}
	
	static int countSwaps(String x, String y) {
		if (identical(x, y)) {
			int count = 0;
			for (int i = 0; i < x.length(); i++) {
				if (x.charAt(i) != y.charAt(i)) count++;
			}
			if (count % 2 == 0) {
				return count / 2;
			}
			return count;
		} else {
			return -1;
		}
	}
	
	static boolean identical(String x, String y) {
		if (x.length() == y.length()) {
			int ones = 0, zeroes = 0;
			for (char c : x.toCharArray()) {
				if (c == '1') ones++;
				else if (c == '0') zeroes++;
			}
			for (char c : y.toCharArray()) {
				if (c == '1') ones--;
				else if (c == '0') zeroes--;
			}
			return ones == 0 && zeroes == 0;
		}
		return false;
	}
}
