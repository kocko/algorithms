package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int toys = sc.nextInt();
		long[] prices = new long[toys];
		int money = sc.nextInt();

		long total = 0;
		for (int i = 0; i < toys; i++) {
			prices[i] = sc.nextInt();
			total += prices[i];
		}
		sc.close();

		int result = toys;
		Arrays.sort(prices);
		int index = toys - 1;
		while (total > money) {
			total -= prices[index--];
			result--;
		}
		System.out.println(result);	
	}
}
