package codeforces.contests101_200.problemset136;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TernaryLogic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();
        int[] ta = ternary(a);
        int[] tc = ternary(c);
        int[] result = untor(ta, tc);
        int answer = toDecimal(result);
        System.out.println(answer);
        sc.close();
    }

    static int[] ternary(int a) {
        int[] result = new int[50];
        int index = 0;
        while (a > 0) {
            result[index++] = a % 3;
            a -= a % 3;
            a /= 3;
        }
        return Arrays.copyOf(result, index);
    }

    static int[] untor(int[] a, int[] c) {
        int min = min(a.length, c.length);
        int max = max(a.length, c.length);
        int[] result = new int[max];
        for (int i = 0; i < min; i++) {
            int mod = (c[i] - a[i]) % 3;
            if (mod < 0) result[i] = 3 + mod;
            else result[i] = mod;
        }
        if (a.length > c.length) {
            for (int i = min; i < max; i++) {
                result[i] = (3 - a[i]) % 3;
            }
        } else if (a.length < c.length) {
            for (int i = min; i < max; i++) {
                result[i] = c[i];
            }
        }
        return result;
    }

    static int toDecimal(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * pow(3, i);
        }
        return result;
    }

    static int pow(int x, int i) {
        if (i == 0) return 1;
        if (i == 1) return x;
        return x * pow (x, i - 1);
    }

}
