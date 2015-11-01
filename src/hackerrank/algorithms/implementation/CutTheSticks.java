package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] sticks = new int[count];
		for (int i = 0; i < count; i++) {
			sticks[i] = sc.nextInt();
		}
		Arrays.sort(sticks);
		cut(sticks);
		sc.close();
	}
	
	static void cut(int[] sticks) {
		int key = sticks[0];
		int n = sticks.length;
		System.out.println(n);
		int count = 1;
		for (int i = 1; i < sticks.length; i++) {
			if (sticks[i] == key) {
				count++;
			} else {
				n -= count;
				System.out.println(n);
				count = 1;
				key = sticks[i];
			}
		}
	}
	
}
