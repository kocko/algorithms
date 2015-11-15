package codeforces.contests001_100.problemset025;

import java.util.Scanner;

public class IQTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		System.out.println(findSpecialNumber(list));
		sc.close();
	}

	static int findSpecialNumber(int[] list) {
		int first = list[0] % 2;
		int second = list[1] % 2;
		int modulo = -1;
		if (first == second) {
			modulo = first;
		} else {
			int third = list[2] % 2;
			if (first == third) {
				modulo = first;
			} else {
				modulo = second;
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 != modulo) {
				return i + 1;
			}
		}
		return 0;
	}

}
