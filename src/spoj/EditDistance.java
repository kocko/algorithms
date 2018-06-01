package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.fill;

public class EditDistance implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            x = in.next().toCharArray();
            y = in.next().toCharArray();
            n = x.length;
            m = y.length;
            dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                fill(dp[i], -1);
            }
            out.println(recurse(0, 0));
        }
    }
    
    private int n, m;
    private char[] x, y;
    private int[][] dp;
    
    private int recurse(int i, int j) {
        if (i == n) return m - j;
        if (j == m) return n - i;
        if (dp[i][j] != -1) return dp[i][j];
        
        int cost = x[i] == y[j] ? 0 : 1;
        return dp[i][j] = min(min(recurse(i + 1, j) + 1, recurse(i, j + 1) + 1), recurse(i + 1, j + 1) + cost);
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
        try (EditDistance instance = new EditDistance()) {
            instance.solve();
        }
    }
}
