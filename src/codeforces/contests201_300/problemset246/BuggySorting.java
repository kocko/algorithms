package codeforces.contests201_300.problemset246;

import java.util.Scanner;

public class BuggySorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n <= 2) {
            System.out.println(-1);
            return;
        }
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
