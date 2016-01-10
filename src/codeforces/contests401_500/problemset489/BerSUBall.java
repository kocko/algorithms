package codeforces.contests401_500.problemset489;

import java.util.Arrays;
import java.util.Scanner;

public class BerSUBall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] g = new int[m];
        for (int i = 0; i < m; i++) {
            g[i] = sc.nextInt();
        }
        Arrays.sort(b);
        Arrays.sort(g);
        int result = 0;
        boolean[] taken = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!taken[j] && Math.abs(b[i] - g[j]) <= 1) {
                    taken[j] = true;
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }

}
