package codeforces.contests601_700.problemset614;

import java.util.Scanner;

public class GenasCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String other = "1";
        long zeroes = 0l;
        boolean uglyFound = false;
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            if (next.equals("0")) {
                System.out.println(0);
                return;
            }
            if (next.equals("1")) continue;
            char[] x = next.toCharArray();
            if (uglyFound) {
                zeroes += x.length - 1;
            } else {
                if (!isPowerOf10(x)) {
                    uglyFound = true;
                    other = next;
                } else {
                    zeroes += x.length - 1;
                }
            }
        }
        System.out.print(other);
        for (int i = 0; i < zeroes; i++)  {
            System.out.print(0);
        }
        System.out.println();
        sc.close();
    }

    static boolean isPowerOf10(char[] n)  {
        boolean result = n[0] == '1';
        if (result) {
            for (int i = 1; i < n.length; i++) {
                if (n[i] != '0') return false;
            }
        }
        return result;
    }

}
