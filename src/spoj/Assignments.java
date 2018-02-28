package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Assignments implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            n = in.ni();
            like = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    like[i][j] = in.ni();
                }
            }
            dp = new long[n][1 << n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1L);
            }
            out.println(recurse(0, 0));
        }
    }
    
    private int n;
    private int[][] like;
    private long[][] dp;
    
    private long recurse(int idx, int mask) {
        if (idx == n) return 1;
        if (dp[idx][mask] != -1) return dp[idx][mask];
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int bit = 1 << i;
            if (like[idx][i] == 1 && (mask & bit) == 0) {
                ans += recurse(idx + 1, mask | bit);
            }
        }
        
        return dp[idx][mask] = ans;
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
        try (Assignments instance = new Assignments()) {
            instance.solve();
        }
    }
}
