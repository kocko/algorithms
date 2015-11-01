package projecteuler;

import java.util.Scanner;

public class TriangleContainment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String next = sc.nextLine();
		while (!"".equals(next)) {
			String[] line = next.split(",");
			long x1 = Long.parseLong(line[0]);
			long y1 = Long.parseLong(line[1]);
			long x2 = Long.parseLong(line[2]);
			long y2 = Long.parseLong(line[3]);
			long x3 = Long.parseLong(line[4]);
			long y3 = Long.parseLong(line[5]);
			double S = calculateArea(x1, y1, x2, y2, x3, y3);
			double S1 = calculateArea(0, 0, x2, y2, x3, y3);
			double S2 = calculateArea(0, 0, x1, y1, x3, y3);
			double S3 = calculateArea(0, 0, x2, y2, x1,	y1);
			if (S1 + S2 + S3 == S) {
				count++;
			}
			next = sc.nextLine();
		}
		System.out.println(count);
		sc.close();
	}
	
	static double calculateArea(long x1, long y1, long x2, long y2, long x3, long y3) {
		double area = 0.0;
		area = 0.5 * det(x1, y1, x2, y2, x3, y3);
		return Math.abs(area);
	}
	
	static long det(long a11, long a12, long a21, long a22, long a31, long a32) {
		return a11 * a22 + a12 * a31 + a21 * a32 - a22 * a31 - a12 * a21 - a11 * a32;
	}
	
}
