package codeforces.contests701_800.problemset706;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class HardProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new long[n];
        dp = new long[n][2];
        words = new String[n][2];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
            dp[i][0] = dp[i][1] = -1;
        }
        for (int i = 0; i < n; i++) {
            words[i][0] = in.next();
            words[i][1] = reverse(words[i][0]);
        }
        long ans = recurse(0, 0);
        out.println(ans >= INF ? -1 : ans);
    }

    private long INF = (long) 1e16;
    private int n;
    private long x[];
    private String[][] words;
    private long[][] dp;

    private long recurse(int idx, int col) {
        if (idx == n) return 0;

        if (dp[idx][col] != -1) return dp[idx][col];

        if (idx == 0) {
            return min(recurse(idx + 1, 0), recurse(idx + 1, 1) + x[idx]);
        }

        long ans = INF;
        if (words[idx - 1][col].compareTo(words[idx][0]) <= 0) {
            ans = min(ans, recurse(idx + 1, 0));
        }
        if (words[idx - 1][col].compareTo(words[idx][1]) <= 0) {
            ans = min(ans, recurse(idx + 1, 1) + x[idx]);
        }

        return dp[idx][col] = ans;
    }

    private String reverse(String word) {
        int n = word.length();
        char[] result = new char[n];
        for (int i = n - 1; i >= 0; i--) result[i] = word.charAt(n - i - 1);
        return new String(result);
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
        try (HardProblem instance = new HardProblem()) {
            instance.solve();
        }
    }
}
