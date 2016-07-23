package codeforces.contests601_700.problemset610;

import java.util.Scanner;

public class VikaAndSquares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 200000;
        int[] c = new int[n];
        long min = Integer.MAX_VALUE, cur, cur0 = 0, max = 0, cur1 = 0;
        for (int i = 0; i < n; i++) {
            c[i] = 1000000000;
            if (c[i] < min) {
                min = c[i];
                cur0 = i;
            }
        }
        cur = c[n - 1];
        int i;
        for (i = 0; i < n; i++) {
            if (c[i] == min) {
                cur = i;
                max = i;
                cur1 = i;
                break;
            }
        }
        for (; i < n; i++) {
            if (c[i] == max) {
                max = Math.max(max, i - cur1 - 1);
                cur1 = 1;
            }
        }
        System.out.println(Math.max(n * min + max, n * min + (n - cur0 - 1) + cur));

    }

}
