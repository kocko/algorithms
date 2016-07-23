package codeforces.contests601_700.problemset603;

import java.util.Scanner;

public class AlternativeThinking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String x = sc.next();
        sc.close();
        int alternating = 1;
        for (int i = 1; i < n; i++) {
            if (x.charAt(i) != x.charAt(i - 1)) {
                alternating++;
            }
        }
        System.out.println(Math.min(alternating + 2, n));
    }

}
