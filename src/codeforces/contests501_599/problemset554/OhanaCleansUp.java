package codeforces.contests501_599.problemset554;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OhanaCleansUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            String next = sc.nextLine();
            Integer count = map.getOrDefault(next, 0);
            map.put(next, count + 1);
            if (count + 1 > max) {
                max = count + 1;
            }
        }
        System.out.println(max);
        sc.close();
    }

}
