package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class DistinctSubsequences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            x = in.next().toCharArray();
            y = in.next().toCharArray();
            n = x.length;
            m = y.length;
            dp = new BigInteger[n][m];
            out.println(recurse(0, 0));
        }
    }

    private int n, m;
    private char[] x, y;
    private BigInteger[][] dp;

    private BigInteger recurse(int i, int j) {
        if (j == m) return BigInteger.ONE;
        if (i == n) return BigInteger.ZERO;

        if (dp[i][j] != null) return dp[i][j];

        BigInteger ans = BigInteger.ZERO;
        if (x[i] == y[j]) {
            ans = ans.add(recurse(i + 1, j + 1));
        }
        ans = ans.add(recurse(i + 1, j));

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
        try (DistinctSubsequences instance = new DistinctSubsequences()) {
            instance.solve();
        }
    }
}
