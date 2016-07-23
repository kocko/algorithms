package codeforces.contests601_700.problemset615;

import java.util.Scanner;

public class Bulbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] switched = new boolean[m + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xi = sc.nextInt();
            for (int j = 0; j < xi; j++) {
                int next = sc.nextInt();
                if (!switched[next]) {
                    count++;
                    switched[next] = true;
                }
            }
        }
        sc.close();
        System.out.println(count == m ? "YES" : "NO");
    }

}
