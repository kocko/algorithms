package codeforces.contests801_900.problemset859;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PieRules implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        pie = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            pie[i] = in.ni();
            total += pie[i];
        }
        int bob = recurse(0, 1);
        out.println((total - bob) + " " + bob);
    }
    
    private int n;
    private int[] pie;
    private int[][] dp;
    
    private int recurse(int idx, int decider) {
        if (idx == n) return 0;
        
        if (dp[idx][decider] != -1) return dp[idx][decider];
        
        int ans;
        if (decider == 1) {
            ans = Math.max(pie[idx] + recurse(idx + 1, 0), recurse(idx + 1, 1));
        } else {
            ans = Math.min(pie[idx] + recurse(idx + 1, decider), recurse(idx + 1, 1));
        }
        
        return dp[idx][decider] = ans;
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
        try (PieRules instance = new PieRules()) {
            instance.solve();
        }
    }
}
