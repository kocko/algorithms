package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int actualDay = sc.nextInt();   int actualMonth = sc.nextInt();   int actualYear = sc.nextInt();
		int expectedDay = sc.nextInt(); int expectedMonth = sc.nextInt(); int expectedYear = sc.nextInt();
		sc.close();
		System.out.println(calculateFare(actualDay, actualMonth, actualYear, expectedDay, expectedMonth, expectedYear));
	}
	
	static int calculateFare(int actualDay,   int actualMonth,   int actualYear, 
							 int expectedDay, int expectedMonth, int expectedYear) {
		if (actualYear > expectedYear) {
			return 10000;
		} else if (actualYear == expectedYear) {
			if (actualMonth == expectedMonth) {
				if (actualDay > expectedDay) {
					return 15 * (actualDay - expectedDay);
				}
			} else if (actualMonth > expectedMonth) {
				return 500 * (actualMonth - expectedMonth);
			}
		}
		return 0;
	}
	
}
