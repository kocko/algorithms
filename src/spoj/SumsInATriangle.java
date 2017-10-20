package spoj;

import java.util.Scanner;

public class SumsInATriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] x = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    x[i][j] = in.nextInt();
                }
            }
            int row = n - 1;
            while (--row >= 0) {
                for (int i = 0; i <= row; i++) x[row][i] += Math.max(x[row + 1][i], x[row + 1][i + 1]);
            }
            System.out.println(x[0][0]);
        }
    }
}
