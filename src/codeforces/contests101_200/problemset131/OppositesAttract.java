package codeforces.contests101_200.problemset131;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OppositesAttract {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) + 1);
            } else {
                map.put(next, 1);
            }
        }
        boolean[] used = new boolean[11];
        long result = 0l;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == 0) {
                result += ((long) value) * (value - 1) / 2;
                used[0] = true;
            } else {
                int opposites = map.getOrDefault(-key, 0);
                if (!used[Math.abs(key)]) {
                    result += ((long) value * opposites);
                    used[Math.abs(key)] = true;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }

}
