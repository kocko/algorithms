package codeforces.contests401_500.problemset416;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArtUnion implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int m = in.ni(), n = in.ni();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = in.ni();
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    int max = dp[i - 1][j];
                    if (j > 0) max = Math.max(dp[i][j - 1], max);
                    dp[i][j] = in.ni() + max;
                }
            }
            out.print(dp[i][n - 1]);
            out.print(' ');
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
        try (ArtUnion instance = new ArtUnion()) {
            instance.solve();
        }
    }
}
