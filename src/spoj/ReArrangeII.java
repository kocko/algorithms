package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class ReArrangeII implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            n = in.ni();
            x = new int[n];
            c = new int[n];
            dp = new int[n][n][1 << 15];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            for (int i = 0; i < n; i++) {
                c[i] = in.ni();
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], oo);    
                }
            }
            int ans = oo;
            for (int i = 0; i < n; i++) {
                ans = min(ans, recurse(1, i, 1 << i));
            }
            out.println(ans);
        }
    }

    private int n, oo = 987654321;
    private int[] x;
    private int[] c;
    private int[][][] dp;

    private int recurse(int idx, int last, int mask) {
        if (idx == n) return 0;
        
        if (dp[idx][last][mask] != oo) return dp[idx][last][mask];
        
        int ans = oo;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int cost = abs(x[i] - x[last]) * c[idx];
                ans = min(ans, cost + recurse(idx + 1, i, mask | (1 << i)));
            }
        }
        return dp[idx][last][mask] = ans;
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
        try (ReArrangeII instance = new ReArrangeII()) {
            instance.solve();
        }
    }
}
