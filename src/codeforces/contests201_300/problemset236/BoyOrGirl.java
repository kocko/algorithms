package codeforces.contests201_300.problemset236;

import java.util.Scanner;

public class BoyOrGirl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] username = sc.next().toCharArray();
        boolean[] used = new boolean[26];
        int result = 0;
        for (char c : username) {
            if (!used[c - 'a']) {
                used[c - 'a'] = true;
                result++;
            }
        }
        System.out.println(result % 2 == 1 ? "IGNORE HIM!" : "CHAT WITH HER!");
        sc.close();
    }

}
