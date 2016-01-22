package codeforces.contests600_699.problemset620;

import java.util.Scanner;

public class GrandfatherDovletsCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] map = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
        long[] result = new long[1000001];
        for (int i = 1; i < result.length; i++) {
            String a = i + "";
            for (char c : a.toCharArray()) {
                result[i] += map[c - '0'];
            }
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        long ans = 0;
        for (int i = a; i <= b; i++) {
            ans += result[i];
        }
        System.out.println(ans);
        sc.close();
    }
}
