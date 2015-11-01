package codeforces.contests001_100.problemset012;

import java.util.Scanner;

public class SuperAgent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] password = new String[3];
		for (int i = 0; i < 3; i++) {
			password[i] = sc.nextLine();
		}
		if (isHorizontallySymmetric(password)
				|| isVerticallySymmetric(password)
				|| isDiagonallySymmetric(password)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		sc.close();
	}

	static boolean isHorizontallySymmetric(String[] password) {
		for (int i = 0; i < 3; i++) {
			if (password[i].charAt(0) != password[i].charAt(2))
				return false;
		}
		if (password[0].charAt(1) != password[2].charAt(1))
			return false;

		return true;
	}

	static boolean isVerticallySymmetric(String[] password) {
		for (int i = 0; i < 3; i++) {
			if (password[0].charAt(i) != password[2].charAt(i))
				return false;
		}
		if (password[1].charAt(0) != password[1].charAt(2))
			return false;
		return true;
	}

	static boolean isDiagonallySymmetric(String[] password) {
		for (int i = 0; i < 3; i++) {
			if (password[0].charAt(i) != password[2].charAt(2 - i))
				return false;
		}
		if (password[1].charAt(0) != password[1].charAt(2))
			return false;
		return true;
	}

}
