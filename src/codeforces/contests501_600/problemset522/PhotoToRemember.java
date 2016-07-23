package codeforces.contests501_600.problemset522;

import java.util.Arrays;
import java.util.Scanner;

public class PhotoToRemember {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] w = new int[n];
		int[] h = new int[n];
		int totalWidth = 0;
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
			totalWidth += w[i];
		}
		int[] copy = Arrays.copyOf(h, n);
		Arrays.sort(h);
		for (int i = 0; i < n; i++) {
			int width = (totalWidth - w[i]);
			int height = (copy[i] == h[n - 1] ? h[n - 2] : h[n - 1]);
			long size = width * height;
			System.out.print(size + " ");
		}
		System.out.println();
		sc.close();
	}

}
