package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PlayWithWords implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        x = in.next().toCharArray();
        int n = x.length;
        dp = new int[n][n];
        int result = 0;
        for (int i = 0; i + 1 < n; i++) {
            result = Math.max(result, recurse(0, i) * recurse(i + 1, n - 1));
        }
        out.println(result);
    }

    private char[] x;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        
        if (i > j) return 0;
        else if (i == j) return 1;

        int ans;
        if (x[i] == x[j]) {
            ans = 2 + recurse(i + 1, j - 1);
        } else {
            ans = Math.max(recurse(i + 1, j), recurse(i, j - 1));
        }
        return (dp[i][j] = ans);
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
        try (PlayWithWords instance = new PlayWithWords()) {
            instance.solve();
        }
    }
}
