package hackerrank.contests.weekofcode28;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyNumberEight implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final long MOD = (long) 1e9 + 7;
    private long[][] dp;
    private char[] x;
    private int n;
    
    public void solve() {
        n = in.ni();
        dp = new long[n][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                dp[i][j] = -1L;
            }
        }
        x = in.next().toCharArray();
        out.println(recurse(0, 0) - 1);
    }
    
    private long recurse(int idx, int m) {
        if (idx == n) return m == 0 ? 1 : 0;

        if (dp[idx][m] != -1) return dp[idx][m];
        
        long result = recurse(idx + 1, m) % MOD;
        result += recurse(idx + 1, (10 * m + (x[idx] - '0')) % 8);
        return dp[idx][m] = result % MOD;
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
        try (LuckyNumberEight instance = new LuckyNumberEight()) {
            instance.solve();
        }
    }
}
