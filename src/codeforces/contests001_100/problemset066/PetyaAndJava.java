package codeforces.contests001_100.problemset066;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class PetyaAndJava implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        BigInteger x = in.nextBigInteger();
        if (within(x, BigInteger.valueOf(Byte.MIN_VALUE), BigInteger.valueOf(Byte.MAX_VALUE))) {
            out.println("byte");
        } else if (within(x, BigInteger.valueOf(Short.MIN_VALUE), BigInteger.valueOf(Short.MAX_VALUE))) {
            out.println("short");
        } else if (within(x, BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.valueOf(Integer.MAX_VALUE))) {
            out.println("int");
        } else if (within(x, BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE))) {
            out.println("long");
        } else {
            out.println("BigInteger");
        }
    }

    private boolean within(BigInteger x, BigInteger left, BigInteger right) {
        return x.compareTo(left) >= 0 && x.compareTo(right) <= 0;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (PetyaAndJava instance = new PetyaAndJava()) {
            instance.solve();
        }
    }
}
