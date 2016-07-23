package codeforces.contests501_600.problemset510;

import java.util.Scanner;

public class FoxAndSnake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        boolean first = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    System.out.print("#");
                } else {
                    if (first) {
                        if (j == m - 1) {
                            System.out.print("#");
                        } else {
                            System.out.print(".");
                        }
                    } else {
                        if (j == 0) {
                            System.out.print("#");
                        } else {
                            System.out.print(".");
                        }
                    }
                }
            }
            if (i % 2 == 1) first = !first;
            System.out.println();
        }
    }
}
