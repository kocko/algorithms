package codeforces.contests1001_1100.problemset1066;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinaryNumbersAndSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[] x = in.next().toCharArray();
        char[] y = in.next().toCharArray();
        long[] prev = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prev[i + 1] = prev[i];
            if (y[i] == '1') {
                prev[i + 1]++;
            }
        }

        long result = 0;
        for (int i = n - 1, j = m; i >= 0; i--, j--) {
            if (j < 0) break;
            int bit = x[i] - '0';
            if (bit == 1) {
                result += (prev[j] * power(n - i - 1)) % MOD;
            }
        }
        out.println(result % MOD);
    }

    private final long MOD = 998244353;

    private long power(int p) {
        if (p == 0) return 1;
        if (p == 1) return 2;
        if (p % 2 == 0) {
            long half = power(p / 2) % MOD;
            return (half * half) % MOD;
        }
        return (2 * power(p - 1)) % MOD;
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
        try (BinaryNumbersAndSum instance = new BinaryNumbersAndSum()) {
            instance.solve();
        }
    }
}
