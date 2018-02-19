package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Aibohphobia implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            s = in.next().toCharArray();
            int n = s.length;
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            int max = recurse(0, n - 1);
            out.println(n - max);
        }
    }

    private char[] s;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (i == j) return 1;
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int ans;
        if (s[i] == s[j]) {
            ans = 2 + recurse(i + 1, j - 1);
        } else {
            ans = Math.max(recurse(i + 1, j), recurse(i, j - 1));
        }
        return dp[i][j] = ans;
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
        try (Aibohphobia instance = new Aibohphobia()) {
            instance.solve();
        }
    }
}
