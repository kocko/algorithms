package uva.volume123;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class PhilipJFryProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while ((n = in.ni()) != 0) {
            t = new int[n];
            f = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = in.ni();
                f[i] = in.ni();
            }
            dp = new Integer[n][n];
            out.println(recurse(0, 0));
        }
    }

    private int n;
    private int[] t, f;
    private Integer[][] dp;

    private Integer recurse(int idx, int feces) {
        if (idx == n) return 0;
        if (dp[idx][feces] != null) return dp[idx][feces];

        int ans = MAX_VALUE, remaining;
        //shorten trip
        if (feces >= 1) {
            remaining = min(feces + f[idx] - 1, n - idx - 1);
            ans = min(ans, t[idx] / 2 + recurse(idx + 1, remaining));
        }
        //don't shorten trip
        remaining = min(n - idx - 1, feces + f[idx]);
        ans = min(ans, t[idx] + recurse(idx + 1, remaining));

        return dp[idx][feces] = ans;
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
        try (PhilipJFryProblem instance = new PhilipJFryProblem()) {
            instance.solve();
        }
    }
}
