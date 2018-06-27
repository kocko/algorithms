package uva.volume107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class StringToPalindrome implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int tests = in.ni();
        for (int testCase = 1; testCase <= tests; testCase++) {
            x = in.next().toCharArray();
            int n = x.length;
            dp = new int[n][n];
            for (int j = 0; j < n; j++) fill(dp[j], -1);
            out.printf("Case %d: %d\n", testCase, recurse(0, n - 1));
        }
    }

    private char[] x;
    private int[][] dp;

    private int recurse(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int ans;
        if (x[i] == x[j]) {
            ans = recurse(i + 1, j - 1);
        } else {
            ans = 1 + recurse(i, j - 1);
            ans = min(ans, 1 + recurse(i + 1, j));
            ans = min(ans, 1 + recurse(i + 1, j - 1));
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
        try (StringToPalindrome instance = new StringToPalindrome()) {
            instance.solve();
        }
    }
}
