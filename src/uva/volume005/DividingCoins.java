package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.abs;

public class DividingCoins implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            int total = 0;
            values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = in.ni();
                total += values[i];
            }
            s = total / 2;
            dp = new int[n][s + 1];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
            int ans = recurse(n - 1, s);
            out.println(abs(total - 2 * ans));
        }
    }
    
    private int s;
    private int[] values;
    private int[][] dp;
    
    private int recurse(int i, int x) {
        if (i < 0 || x == 0) return 0;
        
        if (dp[i][x] != -1) return dp[i][x];
        
        if (values[i] > x) {
            return dp[i][x] = recurse(i - 1, x);
        } else {
            return dp[i][x] = max(recurse(i - 1, x), recurse(i - 1, x - values[i]) + values[i]);
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
        try (DividingCoins instance = new DividingCoins()) {
            instance.solve();
        }
    }
}
