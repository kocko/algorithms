package codeforces.contests401_500.problemset467;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.max;
import static java.util.Arrays.fill;

public class GeorgeAndJob implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni(); m = in.ni(); k = in.ni();
        long[] x = new long[n];
        prefix = new long[n + 1];
        dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            fill(dp[i], -1L);
        }
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        prefix[1] = x[0];
        for (int i = 1; i < n; i++) {
            prefix[i + 1] = prefix[i] + x[i];
        }
        out.println(recurse(0, 0));
    }

    private int n, m, k;
    private long[] prefix;
    private long[][] dp;

    private long recurse(int idx, int start) {
        if (idx == k) return 0L;
        if (start == n + 1) return Integer.MIN_VALUE;
        if (dp[idx][start] != -1L) return dp[idx][start];

        long ans = Integer.MIN_VALUE; 
        if (start + m <= n) {
            ans = prefix[start + m] - prefix[start] + recurse(idx + 1, start + m);
        }
        ans = max(ans, recurse(idx, start + 1));
        return dp[idx][start] = ans;
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
        try (GeorgeAndJob instance = new GeorgeAndJob()) {
            instance.solve();
        }
    }
}
