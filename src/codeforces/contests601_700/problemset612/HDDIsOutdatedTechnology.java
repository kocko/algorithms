package codeforces.contests601_700.problemset612;

import java.util.Scanner;

import static java.lang.Math.abs;

public class HDDIsOutdatedTechnology {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[sc.nextInt()] = i;
        }
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result += abs(f[i] - f[i - 1]);
        }
        System.out.println(result);
        sc.close();
    }

}
