package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine().trim());
		for (int i = 0; i < testCases; i++) {
			int size = Integer.parseInt(sc.nextLine().trim());
			String[] input = new String[size];
			for (int j = 0; j < size; j++) {
				input[j] = sc.nextLine();
			}
			System.out.println(processInput(input));
		}
		sc.close();
	}
	
	static String processInput(String[] input) {
		int n = input.length;
		String[] output = new String[n];
		for (int i = 0; i < n; i++) {
			String next = input[i];
			char[] letters = next.toCharArray();
			Arrays.sort(letters);
			output[i] = new String(letters);
		}
		return verifyOutput(output);
	}
	
	static String verifyOutput(String[] output) {
		int n = output.length;		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (output[i - 1].charAt(j) > output[i].charAt(j)) {
					return "NO";
				}
			}
		}
		return "YES";
	}
}
