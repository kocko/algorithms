package codeforces.contests401_500.problemset469;

import java.util.Scanner;

public class IWannaBeTheGuy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] stages = new boolean[n + 1];
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) {
			stages[sc.nextInt()] = true;
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			stages[sc.nextInt()] = true;
		}
		String result = "I become the guy.";
		for (int i = 1; i <= n; i++) {
			if (!stages[i]) {
				result = "Oh, my keyboard!";
				break;
			}
		}
		System.out.println(result);
		sc.close();
	}
	
}
