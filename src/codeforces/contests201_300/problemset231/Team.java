package codeforces.contests201_300.problemset231;

import java.util.Scanner;

public class Team {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt() + sc.nextInt() + sc.nextInt();
            if (count >= 2) result++;
        }
        System.out.println(result);
        sc.close();
    }
}
