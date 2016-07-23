package codeforces.contests601_700.problemset616;

import java.util.Scanner;

public class DinnerWithEmma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int next = sc.nextInt();
                min = Math.min(next, min);
            }
            result = Math.max(result, min);
        }
        System.out.println(result);
        sc.close();
    }

}
