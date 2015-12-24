package codeforces.contests101_200.problemset118;

import java.util.Scanner;

public class PresentFromLena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printHandkerchief(sc.nextInt(), 0);
        sc.close();
    }

    static void printHandkerchief(int n, int i) {
        if (n < i) {
            return;
        }
        spaces(2 * (n - i));
        row(i, 0);
        System.out.println();
        printHandkerchief(n, i + 1);
        if (n != i) {
            spaces(2 * (n - i));
            row(i, 0);
            System.out.println();
        }
    }

    static void spaces(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(" ");
        }
    }

    static void row(int n, int i) {
        if (n < i) {
            return;
        }
        if (i == n && i == 0) {
            System.out.print(i);
        } else {
            System.out.print(i + " ");
        }
        row(n, i + 1);
        if (n != i) {
            System.out.print(i);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

}
