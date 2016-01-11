package codeforces.contests501_599.problemset580;

import java.util.Scanner;

public class KefaAndFirstSteps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m;
        int current = 0, last = -1, answer = 0;
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            if (m >= last) {
                current++;
            } else {
                answer = Math.max(answer, current);
                current = 1;
            }
            last = m;
        }
        System.out.println(Math.max(answer, current));
        sc.close();
    }

}
