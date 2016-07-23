package codeforces.contests501_600.problemset508;

import java.util.Scanner;

public class AntonAndCurrencyYouAllKnow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        sc.close();
        int n = a.length;
        boolean ok = false;
        int last = a[n - 1] - '0';
        for (int i = 0; i < n; i++) {
            int next = (a[i] - '0');
            if (next % 2 == 0 && next < last) {
                char temp = a[i];
                a[i] = a[n - 1];
                a[n - 1] = temp;
                ok = true;
                break;
            }
        }
        if (ok) {
            for (char c : a) {
                System.out.print(c);
            }
            System.out.println();
            return;
        } else {
            for (int i = n - 2; i >= 0; i--) {
                int next = (a[i] - '0');
                if (next % 2 == 0 && next > last) {
                    char temp = a[i];
                    a[i] = a[n - 1];
                    a[n - 1] = temp;
                    ok = true;
                    break;
                }
            }
        }
        if (ok) {
            for (char c : a) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

}
