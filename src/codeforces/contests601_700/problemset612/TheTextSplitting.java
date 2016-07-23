package codeforces.contests601_700.problemset612;

import java.util.Scanner;

public class TheTextSplitting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        sc.close();
        int i, j = 0;
        boolean found = false;
        out: for (i = 0; i <= n; i++) {
            for (j = 0; j <= n; j++) {
                if (p * i + q * j == n) {
                    found = true;
                    break out;
                }
            }
        }
        if  (!found) {
            System.out.println(-1);
            return;
        }
        System.out.println(i + j);
        for (int a = 0; a < i; a++) {
            System.out.println(s.substring(a * p, a * p + p));
        }
        int start = i * p;
        for (int a = 0; a < j; a++) {
            System.out.println(s.substring(start + a * q, start + a * q + q));
        }
    }
}
