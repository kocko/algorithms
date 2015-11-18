package codeforces.contests501_599.problemset591;

import java.util.Scanner;

public class WizardsDuel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		System.out.println(p * ((double) l / (p + q)));
		sc.close();
	}
}
