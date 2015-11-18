package codeforces.contests001_100.problemset096;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Football {

	static Pattern ONE = Pattern.compile("^[0-1]*[1]{7,}[0-1]*$");
	static Pattern ZERO = Pattern.compile("^[0-1]*[0]{7,}[0-1]*$");
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		if (ONE.matcher(s).matches() || ZERO.matcher(s).matches()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
}
