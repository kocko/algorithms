package codeforces.contests801_900.problemset898;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class RestoringTheExpression implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        powers = new long[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = powers[i - 1] * base;
            powers[i] %= MOD;
        }

        hash = new long[n];
        hash[0] = x[0] - '0';
        for (int i = 1; i < n; i++) {
            hash[i] = (hash[i - 1] * base) % MOD;
            hash[i] += (x[i] - '0');
            hash[i] %= MOD;
        }
        //brute force on r <- the size of the sum (p + q = r)
        for (int r = 1; r <= n; r++) {
            if (x[n - r] == '0' && r > 1) continue;
            for (int p : new int[]{r, r - 1, n - 2 * r, n - 2 * r + 1}) {
                int q = n - r - p;
                //validate p and q
                if (p <= 0 || q <= 0) continue;
                if (x[0] == '0' && p > 1) continue;
                if (x[p] == '0' && q > 1) continue;
                long p_ = value(0, p - 1);
                long q_ = value(p, n - r - 1);
                long r_ = value(n - r, n - 1);
                if ((p_ + q_) % MOD == r_) {
                    for (int i = 0; i < p; i++) out.print(x[i]);
                    out.print("+");
                    for (int i = p; i < p + q; i++) out.print(x[i]);
                    out.print("=");
                    for (int i = p + q; i < n; i++) out.print(x[i]);
                    return;
                }
            }
        }
    }

    private long[] powers, hash;
    private final long base = 10, MOD = BigInteger.probablePrime(30, new Random()).longValue();

    private long value(int left, int right) {
        if (left == 0) return hash[right];
        return (hash[right] - hash[left - 1] * powers[right - left + 1] % MOD + MOD) % MOD;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (RestoringTheExpression instance = new RestoringTheExpression()) {
            instance.solve();
        }
    }
}
