package codeforces.contests101_200.problemset137;

import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = sc.nextInt();
        }

        boolean[] used = new boolean[5001];
        for (int i : perm) {
            used[i] = true;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i]) result++;
        }
        System.out.println(result);
        sc.close();
    }

}
