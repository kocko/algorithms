package codeforces.contests501_599.problemset599;

import java.util.Scanner;

public class C {
	
	static class Point {
		int x; int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int specialValue() {
			return y - x;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point[] list = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[i] = new Point(x, y);
		}
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
		}
		sc.close();
		
		Point[] result = solve(list, w);
		if (result != null) {
			System.out.println("YES");
			for (Point p : result) {
				System.out.println(p.x + " " + p.y);
			}
		} else {
			System.out.println("NO");
		}
	}
	
	static Point[] solve(Point[] list, int[] w) {
		int n = list.length;
		Point[] result = new Point[n];
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; i++) {
			Point point = list[i];
			int special = point.specialValue();
			boolean ok = false;
			in: for (int j = 0; j < n; j++) {
					if ((w[j] == special) && !used[j]) {
						ok = true;
						used[j] = true;
						result[j] = point;
						break in;
					}
				}
			if (!ok) {
				return null;
			}
		}
		return result;
	}
}
