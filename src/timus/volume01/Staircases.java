package timus.volume01;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Staircases implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        dp = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) Arrays.fill(dp[i], -1);
        out.println(recurse(0, n) - 1);
    }

    private long[][] dp;

    private long recurse(int prev, int remain) {
        if (dp[prev][remain] != -1) return dp[prev][remain];

        if (remain == 0) return 1;
        if (remain <= prev) return 0;

        long ans = 0;
        for (int i = prev + 1; i <= remain; i++) {
            ans += recurse(i, remain - i);
        }

        return dp[prev][remain] = ans;
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
        try (Staircases instance = new Staircases()) {
            instance.solve();
        }
    }
}
