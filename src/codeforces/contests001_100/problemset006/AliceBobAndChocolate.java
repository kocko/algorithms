package codeforces.contests001_100.problemset006;

import java.util.Scanner;

public class AliceBobAndChocolate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] times = new int[k];
		for (int i = 0; i < k; i++) {
			times[i] = sc.nextInt();
		}
		int[] result = consume(times);
		System.out.println(result[0] + " " + result[1]);
		sc.close();
	}
	
	static int[] consume(int[] times) {
		int alice = 0, aliceTime = 0;
		int bob = 0, bobTime = 0;
		int size = times.length;
		int aliceIndex = 0, bobIndex = size - 1;
		boolean[] eaten = new boolean[size];
		while (true) {
			if (aliceTime <= bobTime) {
				if (!eaten[aliceIndex]) {
					alice++;
					aliceTime += times[aliceIndex];
					eaten[aliceIndex++] = true;
				} else break;
			} else {
				if (!eaten[bobIndex]) {
					bob++;
					bobTime += times[bobIndex];
					eaten[bobIndex--] = true;
				} else break;
			}
		}
		return new int[] { alice, bob };
	}
}
