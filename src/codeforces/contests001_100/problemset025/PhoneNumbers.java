package codeforces.contests001_100.problemset025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String number = sc.next();
		System.out.println(splitNumberIntoGroups(number));
		sc.close();
	}

	static String splitNumberIntoGroups(String number) {
		int n = number.length();
		List<String> result = new ArrayList<>();
		int a = n;
		while (true) {
			if (a % 2 == 0) break;
			else {
				a -= 3;
			}
		}
		
		for (int i = 0; i < a; i += 2) {
			result.add(new String(new char[]{number.charAt(i), number.charAt(i + 1)}));
		}
		for (int i = a; i < n; i += 3) {
			result.add(new String(new char[]{number.charAt(i), number.charAt(i + 1), number.charAt(i + 2)}));
		}
		return result.stream().collect(Collectors.joining("-"));
	}
}
