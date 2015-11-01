package codeforces.contests001_100.problemset012;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Boolean.*;

public class SuperAgent {

	@SuppressWarnings("serial")
	static final Map<Boolean, String> OUTCOMES = new HashMap<Boolean, String>() {
		{
			put(TRUE, "YES");
			put(FALSE, "NO");
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = new String[3];
		for (int i = 0; i < 3; i++) {
			input[i] = sc.nextLine();
		}
		System.out.println(isSymmetric(input));
		sc.close();
	}
	
	static String isSymmetric(String[] input) {
		for (String s : input) {
			if (s.charAt(0) != s.charAt(2)) {
				return OUTCOMES.get(FALSE);
			}
		}
		for (int i = 0; i < 3; i++) {
			if (input[0].charAt(0) != input[2].charAt(i)) {
				return OUTCOMES.get(FALSE);
			}
		}
		if (input[0].charAt(0) != input[2].charAt(2)) {
			return OUTCOMES.get(FALSE);
		}
		if (input[0].charAt(2) != input[2].charAt(0)) {
			return OUTCOMES.get(FALSE);
		}
		return OUTCOMES.get(TRUE);
	}
}
