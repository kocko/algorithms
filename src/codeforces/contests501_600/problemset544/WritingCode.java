package codeforces.contests501_600.problemset544;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WritingCode implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), b = in.ni(), MOD = in.ni();
        int[][] dp = new int[m + 1][b + 1];
        dp[0][0] = 1;
        for (int it = 0; it < n; it++) {
            int errors = in.ni();
            for (int bugs = 0; bugs <= b; bugs++) {
                for (int lines = 0; lines <= m; lines++) {
                    if (lines + 1 <= m && bugs + errors <= b) {
                        dp[lines + 1][bugs + errors] += dp[lines][bugs];
                        while (dp[lines + 1][bugs + errors] >= MOD) dp[lines + 1][bugs + errors] -= MOD;
                    }
                }
            }
        }
        long result = 0L;
        for (int bugs = 0; bugs <= b; bugs++) {
            result += dp[m][bugs];
            while (result >= MOD) result -= MOD;
        }
        out.println(result);
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
        try (WritingCode instance = new WritingCode()) {
            instance.solve();
        }
    }
}
