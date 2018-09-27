package codeforces.contests1001_1100.problemset1051;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bicolorings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        k = in.ni();
        long result = 0;
        dp = new Long[n][k][4];
        for (int i = 0; i < 4; i++) {
            int components = (i == 0 || i == 3) ? 1 : 2;
            result += recurse(1, k - components, i);
            result %= MOD;
        }
        out.println(result);
    }

    private final long MOD = 998244353;
    private int n, k;
    private Long[][][] dp;

    private long recurse(int idx, int left, int prev) {
        if (left < 0) return 0;
        if (idx == n) return left == 0 ? 1 : 0;
        if (dp[idx][left][prev] != null) return dp[idx][left][prev];

        long result = 0;
        if (prev == 0) {
            for (int column = 0; column < 4; column++) {
                int remaining = column > 0 ? left - 1 : left;
                result += recurse(idx + 1, remaining, column);
            }
        }
        if (prev == 1) {
            for (int column = 0; column < 4; column++) {
                int remaining = column == 2 ? left - 2 : left;
                result += recurse(idx + 1, remaining, column);
            }
        }
        if (prev == 2) {
            for (int column = 0; column < 4; column++) {
                int remaining = column == 1 ? left - 2 : left;
                result += recurse(idx + 1, remaining, column);
            }
        }
        if (prev == 3) {
            for (int column = 0; column < 4; column++) {
                int remaining = column == 3 ? left : left - 1;
                result += recurse(idx + 1, remaining, column);
            }
        }
        return dp[idx][left][prev] = result % MOD;
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
        try (Bicolorings instance = new Bicolorings()) {
            instance.solve();
        }
    }
}
