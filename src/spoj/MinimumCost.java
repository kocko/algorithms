package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.util.Arrays.fill;

public class MinimumCost implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (true) {
            String s = in.next();
            if ("#".equals(s)) break;
            this.x = s.toCharArray();
            this.y = in.next().toCharArray();
            this.n = x.length;
            this.m = y.length;
            dp = new int[n][m];
            for (int i = 0; i < n; i++) fill(dp[i], -1);
            int lcs = recurse(0, 0);
            out.println((n - lcs) * 15 + (m - lcs) * 30);
        }
    }

    private int n, m;
    private char[] x, y;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (i == n || j == m) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int ans;
        if (x[i] == y[j]) {
            ans = 1 + recurse(i + 1, j + 1);
        } else {
            ans = max(recurse(i, j + 1), recurse(i + 1, j));
        }

        return dp[i][j] = ans;
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
        try (MinimumCost instance = new MinimumCost()) {
            instance.solve();
        }
    }
}
