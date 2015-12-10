package codeforces.contests600_699.problemset606;

import java.util.Scanner;

public class MagicSpheres {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] have = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };
		int[] want = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };
		sc.close();
		for (int i = 0; i < 3; i++) {
			if (have[i] > want[i]) {
				int diff = have[i] - want[i];
				if (diff % 2 == 1) diff--;
				have[i] -= diff;
				diff >>= 1;
				for (int j = 0; j < 3; j++) {
					if (i != j && have[j] < want[j]) {
						int need = want[j] - have[j];
						if (need <= diff) {
							diff -= need;
							have[j] += need;
						} else {
							have[j] += diff;
						}
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (have[i] < want[i]) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
	
}
