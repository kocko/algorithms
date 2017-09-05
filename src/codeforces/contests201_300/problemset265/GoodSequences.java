package codeforces.contests201_300.problemset265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GoodSequences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int MAX = 100001, n = in.ni();
        int[] x = new int[n];
        int[] dp = new int[MAX];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            int max = 0;
            for (int j = 2; j * j <= x[i]; j++) {
                if (x[i] % j == 0) {
                    max = Math.max(max, Math.max(dp[x[i] / j], dp[j]));
                }
            }
            for (int j = 1; j * j <= x[i]; j++) {
                if (x[i] % j == 0) {
                    dp[j] = dp[x[i] / j] = max + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < MAX; i++) {
            ans = Math.max(ans, dp[i]);
        }
        out.println(ans);
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
        try (GoodSequences instance = new GoodSequences()) {
            instance.solve();
        }
    }
}
