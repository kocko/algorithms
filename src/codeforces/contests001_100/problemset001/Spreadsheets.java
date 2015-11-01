package codeforces.contests001_100.problemset001;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Spreadsheets {

	static final Pattern PATTERN = Pattern.compile("R[0-9]+C[0-9]+");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testCases; i++) {
			String input = sc.nextLine().trim();
			System.out.println(convert(input));
		}
		sc.close();
	}

	static String convert(String input) {
		return PATTERN.matcher(input).matches() ? convertToExcel(input) : convertToOther(input);
	}

	static String convertToExcel(String input) {
		final int zero = 'A' - 1;
		int c = input.indexOf('C');
		String row = input.substring(1, c);
		String col = input.substring(c + 1);
		Integer number = Integer.parseInt(col);
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int rem = number % 26;
			if (rem == 0) {
				rem = 26;
			}
			sb.append((char) (zero + rem));
			number -= rem;
			number /= 26;
		}
		return sb.reverse() + row;
	}

	static String convertToOther(String input) {
		char[] chars = input.toCharArray();
		int row = -1;
		String col = "";
		for (int i = 0; i < chars.length; i++) {
			if (Character.isDigit(chars[i])) {
				row = row == -1 ? chars[i] - '0' : (10 * row) + (chars[i] - '0');
			} else {
				col += chars[i];
			}
		}
		int column = 0;
		char[] letters = col.toCharArray();
		int n = letters.length;
		for (int i = n - 1; i >= 0; i--) {
			column += (letters[i] - 'A' + 1) * Math.pow(26, (n - i - 1));
		}
		return "R" + row + "C" + column;
	}

}