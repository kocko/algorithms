package codeforces.contests501_599.problemset583;

import java.util.Scanner;

public class RobotsTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pc = new int[n];
        for (int i = 0; i < n; i++) {
            pc[i] = sc.nextInt();
        }
        int collected = 0;
        int result = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (pc[i] <= collected) {
                    collected++;
                    pc[i] = n + 1;
                }
            }
            if (collected == n) break;
            result++;

            for (int i = n - 1; i >= 0; i--) {
                if (pc[i] <= collected) {
                    collected++;
                    pc[i] = n + 1;
                }
            }
            if (collected == n) break;
            result++;
        }
        System.out.println(result);
        sc.close();
    }
}
