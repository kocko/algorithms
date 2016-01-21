package codeforces.contests600_699.problemset620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GrandfatherDovletsCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, 6);
            put(1, 2);
            put(2, 5);
            put(3, 5);
            put(4, 4);
            put(5, 5);
            put(6, 6);
            put(7, 3);
            put(8, 7);
            put(9, 6);
        }};
        long[] result = new long[1000001];
        for (int i = 1; i < result.length; i++) {
            String a = i + "";
            for (char c : a.toCharArray()) {
                result[i] += map.get(c - '0');
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
