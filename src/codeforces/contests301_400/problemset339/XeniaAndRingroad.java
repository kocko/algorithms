package codeforces.contests301_400.problemset339;

import java.util.Scanner;

public class XeniaAndRingroad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        long result = 0;
        int last = 1;
        for (int i : a) {
            if (i > last) {
                result += (i - last);
            } else if (i < last) {
                result += (n - last + i);
            }
            last = i;
        }
        System.out.println(result);
        sc.close();
    }

}
