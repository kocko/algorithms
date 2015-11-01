package hackerrank.contests.codewhiz;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		while (testCases > 0) {
			String pattern = sc.nextLine();
			boolean valid = checkValidity(pattern);
			System.out.println(valid ? "Valid" : "Invalid");
		}
		sc.close();
	}
	
	static boolean checkValidity(String pattern) {
		try {
			Pattern.compile(pattern);
		} catch (PatternSyntaxException e) {
			return false;
		}
		return true;	
	}
}
