package codeforces.contests401_500.problemset445;

import java.util.Scanner;

public class DZYLovesChessboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] table = new char[n][m];
        for (int i = 0; i < n; i++) {
            table[i] = sc.next().toCharArray();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            char next = (i % 2 == 0) ? 'B' : 'W';
            for (int j = 0; j < m; j++) {
                if (table[i][j] == '.') {
                    System.out.print(next);
                } else if (table[i][j] == '-') {
                    System.out.print(table[i][j]);
                }
                next = (next == 'W') ? 'B' : 'W';
            }
            System.out.println();
        }

    }
}
