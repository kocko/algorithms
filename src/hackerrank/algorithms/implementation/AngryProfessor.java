package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		String[] result = new String[testCases];
		for (int i = 0; i < testCases; i++) {			
			int k = Integer.parseInt(sc.nextLine().split("\\s+")[1]);
			String arrivalsLine = sc.nextLine();
			String[] arrivals = arrivalsLine.split("\\s+");
			result[i] = processArrivals(k, arrivals);
		}
		sc.close();
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	static String processArrivals(int k, String[] arrivals) {
		int early = 0;
		for (String arrival : arrivals) {
			if (Integer.parseInt(arrival) <= 0) {
				early++;
			}
		}
		return early < k ? "YES" : "NO";
	}
}
