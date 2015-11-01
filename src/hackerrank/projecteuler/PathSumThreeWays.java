package hackerrank.projecteuler;

import java.util.Scanner;

public class PathSumThreeWays {

	static final int MAX = 5;
	
	static int[][] matrix = new int[MAX][MAX];
	
	public static void main(String[] args) {
		readInput();
		System.out.println(calculateMaxPathSum());
	}
	
	static void readInput() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	
	static int calculateMaxPathSum() {
		int[][] dp = new int[MAX][MAX];
		for (int i = 0; i < MAX; i++) {
			
		}
		return 0;
	}
	
}
