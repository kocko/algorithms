package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ServiceLane {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int testCases = sc.nextInt();
		int[] lane = new int[size];
		for (int i = 0; i < size; i++) {
			lane[i] = sc.nextInt();
		}
		for (int i = 0; i < testCases; i++) {
			int start = sc.nextInt();
			int end  = sc.nextInt();
			System.out.println(calculateLargestVehicle(lane, start, end));
		}
		sc.close();
	}
	
	static int calculateLargestVehicle(int[] lane, int start, int end) {
		int result = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (lane[i] < result) { 
				result = lane[i];
			}
		}
		return result;
	}
	
}
