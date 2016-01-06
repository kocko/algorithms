package codeforces.contests401_500.problemset469;

import java.util.Scanner;

public class ChatOnline {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();

        int[][] z = new int[p][2];
		for (int i = 0; i < p; i++) {
			z[i][0] = sc.nextInt();
            z[i][1] = sc.nextInt();
		}

        boolean[] ok = new boolean[1001];
        int result = 0;
		for (int i = 0; i < q; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
            for (int j = l; j <= r; j++) {
                int left = c + j;
                int right = d + j;
                for (int[] x : z) {
                    if ((left >= x[0] && left <= x[1]) || (right >= x[0] && right <= x[1]) || (left <= x[0] && right >= x[1])) {
                        if (!ok[j]) {
                            result++;
                            ok[j] = true;
                        }
                        break;
                    }
                }
            }
		}
        System.out.println(result);
        sc.close();
	}

}
