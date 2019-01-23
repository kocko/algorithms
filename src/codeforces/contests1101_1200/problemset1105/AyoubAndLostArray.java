package codeforces.contests1101_1200.problemset1105;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AyoubAndLostArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        int left = in.ni();
        int right = in.ni();
        int lo = left % 3 == 0 ? left : left + (3 - left % 3);
        int hi = right - right % 3;
        if (hi >= lo) {
            zeroes = (hi - lo) / 3 + 1;
        }

        lo = left % 3 == 0 ? left + 1 : (left % 3 == 1 ? left : left + 2);
        hi = right % 3 == 0 ? right - 2 : (right % 3 == 1 ? right : right - 1);
        if (hi >= lo) {
            ones = (hi - lo) / 3 + 1;
        }

        twos = (right - left + 1 - zeroes - ones);

        dp = new Long[n][3];
        out.println(recurse(0, 0));
    }

    private int n;
    private int zeroes, ones, twos;

    private final long MOD = (long) 1e9 + 7;
    private Long[][] dp;

    private long recurse(int idx, int rem) {
        if (idx == n) return rem == 0 ? 1 : 0;
        if (dp[idx][rem] != null) return dp[idx][rem];

        long ans = 0;
        ans += zeroes * recurse(idx + 1, rem);
        ans %= MOD;

        ans += ones * recurse(idx + 1, (rem + 1) % 3);
        ans %= MOD;

        ans += twos * recurse(idx + 1, (rem + 2) % 3);
        ans %= MOD;

        return dp[idx][rem] = ans % MOD;
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
        try (AyoubAndLostArray instance = new AyoubAndLostArray()) {
            instance.solve();
        }
    }
}
