package codeforces.contests301_400.problemset368;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerejaAndSuffixes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        boolean[] seen = new boolean[(int) 1e5 + 1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        int[] dp = new int[n];
        dp[n - 1] = 1;
        seen[a[n - 1]] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (!seen[a[i]]) {
                seen[a[i]] = true;
                dp[i] = 1 + dp[i + 1];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        while (q-- > 0) {
            out.println(dp[in.ni() - 1]);
        }
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
        try (SerejaAndSuffixes instance = new SerejaAndSuffixes()) {
            instance.solve();
        }
    }
}
