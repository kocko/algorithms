package codeforces.contests600_699.problemset614;

import java.math.BigInteger;
import java.util.Scanner;

public class LinkCutTree {

    static BigInteger bi(Scanner sc) {
        return new BigInteger(sc.next());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger l = bi(sc);
        BigInteger r = bi(sc);
        BigInteger k = bi(sc);
        BigInteger start = BigInteger.ONE;
        while (start.compareTo(l) < 0) {
            start = start.multiply(k);
        }
        boolean ok = false;
        while (true) {
            if (start.compareTo(r) > 0) break;
            else {
                ok = true;
                System.out.print(start + " ");
            }
            start = start.multiply(k);
        }
        if (!ok) System.out.println(-1);
        sc.close();
    }

}
