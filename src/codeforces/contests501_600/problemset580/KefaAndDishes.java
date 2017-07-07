package codeforces.contests501_600.problemset580;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.bitCount;

public class KefaAndDishes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        int k = in.ni();
        satisfaction = new long[n];
        for (int i = 0; i < n; i++) {
            satisfaction[i] = in.nl();
        }
        rules = new long[n][n];
        for (int i = 0; i < k; i++) {
            rules[in.ni() - 1][in.ni() - 1] = in.nl();
        }
        dp = new long[n][1 << n];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, satisfaction[i] + recurse(i, 1 << i));
        }
        out.println(result);
    }
    
    private int n, m;
    private long[] satisfaction;
    private long[][] rules;
    private long[][] dp;
    
    private long recurse(int idx, int mask) {
        if (bitCount(mask) == m) return dp[idx][mask] = 0;
        
        if (dp[idx][mask] != -1) return dp[idx][mask];
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                ans = Math.max(ans, satisfaction[i] + rules[idx][i] + recurse(i, mask | (1 << i)));
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
        try (KefaAndDishes instance = new KefaAndDishes()) {
            instance.solve();
        }
    }
}
