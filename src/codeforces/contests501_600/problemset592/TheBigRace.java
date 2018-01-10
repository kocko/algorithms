package codeforces.contests501_600.problemset592;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Long.min;

public class TheBigRace implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        BigInteger T = in.nextBigInteger(), w = in.nextBigInteger(), b = in.nextBigInteger();
        BigInteger lcm = w.divide(w.gcd(b)).multiply(b);
        BigInteger less = w.min(b);
        BigInteger p = T.divide(lcm).multiply(less).add(T.mod(lcm).min(less.subtract(BigInteger.ONE)));
        BigInteger gcd = p.gcd(T);
        p = p.divide(gcd);
        T = T.divide(gcd);
        out.printf("%s/%s\n", p.toString(), T.toString());
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TheBigRace instance = new TheBigRace()) {
            instance.solve();
        }
    }
}
