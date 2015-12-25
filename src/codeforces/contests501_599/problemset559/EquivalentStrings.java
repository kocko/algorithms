package codeforces.contests501_599.problemset559;

import java.util.Scanner;

public class EquivalentStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        System.out.println(smallest(a).equals(smallest(b)) ? "YES" : "NO");
    }

    static String smallest(String a) {
        int n = a.length();
        if (n % 2 == 1) {
            return a;
        }
        String s1 = smallest(a.substring(0, n / 2));
        String s2 = smallest(a.substring(n / 2));
        return s1.compareTo(s2) < 0 ? (s1 + s2) : (s2 + s1);
    }

}
