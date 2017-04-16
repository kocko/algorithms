package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayQueries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.ni();
        }
        dp = new int[n + 1][360];
        int q = in.ni();
        while (q-- > 0) {
            out.println(recurse(in.ni(), in.ni()));
        }
    }

    private int[] a;
    private int[][] dp;
    private int n;

    private int recurse(int p, int k) {
        if (p > n) return 0;
        if (k > 350) return recurse(p + a[p] + k, k) + 1;
        return dp[p][k] = (dp[p][k] != 0 ? dp[p][k] : 1 + recurse(p + k + a[p], k));
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
        try (ArrayQueries instance = new ArrayQueries()) {
            instance.solve();
        }
    }
}
