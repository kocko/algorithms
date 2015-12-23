package codeforces.contests101_200.problemset136;

import java.util.Scanner;

public class Presents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[sc.nextInt()] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        sc.close();
    }

}
