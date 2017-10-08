package codeforces.contests501_600.problemset545;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Woodcutters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        if (n == 1) {
            out.println(1);
            return;
        }
        x = new int[n];
        h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            h[i] = in.ni();
        }
        dp = new int[n][3];
        for (int i = 0; i < n; i++) dp[i][0] = dp[i][1] = dp[i][2] = -1;
        out.println(2 + recurse(1, 1));
    }

    private int n;
    private int[] x, h;
    private int[][] dp;

    private int recurse(int idx, int state) {
        if (idx >= n - 1) return 0;
        if (dp[idx][state] != -1) return dp[idx][state];

        int result = recurse(idx + 1, 0);
        if (state <= 1) {
            if (x[idx] - h[idx] > x[idx - 1]) {
                result = Math.max(result, 1 + recurse(idx + 1, 1));
            }
        } else {
            if (x[idx] - h[idx] > x[idx - 1] + h[idx - 1]) {
                result = Math.max(result, 1 + recurse(idx + 1, 1));
            }
        }
        if (x[idx] + h[idx] < x[idx + 1]) {
            result = Math.max(result, 1 + recurse(idx + 1, 2));
        }

        return dp[idx][state] = result;
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
        try (Woodcutters instance = new Woodcutters()) {
            instance.solve();
        }
    }
}
