package codeforces.contests101_200.problemset131;

import java.math.BigInteger;
import java.util.Scanner;

public class TheWorldIsATheatre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        long result = 0L;
        for (int b = 4; b <= n; b++) {
            if (t - b >= 1) {
                long nb = comb(n, b);
                long mg = comb(m, t - b);
                result += nb * mg;
            }
        }
        System.out.println(result);
        sc.close();
    }

    static long comb(int n, int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i <= k - 1; i++) {
            result = result.multiply(BigInteger.valueOf(n - i));
        }
        result = result.divide(fact(k));
        return result.longValue();
    }

    static BigInteger fact(int a) {
        return a == 1 ? BigInteger.ONE : BigInteger.valueOf(a).multiply(fact(a - 1));
    }
}
