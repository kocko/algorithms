package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class TrainingForFinal implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), x = in.ni() - 1, y = in.ni() - 1;
        int[][] power = new int[n][m], dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                power[i][j] = in.ni();
            }
        }
        dp[n - 1][m - 1] = power[n - 1][m - 1];
        for (int i = n - 2; i >= 0; i--) dp[i][m - 1] = dp[i + 1][m - 1] + power[i][m - 1];
        for (int j = m - 2; j >= 0; j--) dp[n - 1][j] = dp[n - 1][j + 1] + power[n - 1][j];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + power[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        if (x + 1 < n) min = min(min, dp[x + 1][y]);
        if (y + 1 < m) min = min(min, dp[x][y + 1]);
        int ans = power[x][y] - (min != Integer.MAX_VALUE ? min : 0);
        if (ans >= 0) {
            out.println("Y " + ans);
        } else {
            out.println("N");
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
        try (TrainingForFinal instance = new TrainingForFinal()) {
            instance.solve();
        }
    }
}
