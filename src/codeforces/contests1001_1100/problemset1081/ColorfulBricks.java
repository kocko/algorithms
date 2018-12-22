package codeforces.contests1001_1100.problemset1081;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColorfulBricks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        k = in.ni();
        dp = new Long[n][k + 1];
        out.println(recurse(0, 0));
    }
    
    private int n, m, k;
    private Long[][] dp;
    
    private Long recurse(int idx, int count) {
        final long MOD = 998244353;
        if (count > k) return 0L;
        if (idx == n) return count == k ? 1L : 0L;
        
        if (dp[idx][count] != null) return dp[idx][count];
        
        long ans;
        if (idx == 0) {
            ans = recurse(idx + 1, count) * m;   
        } else {
            ans = recurse(idx + 1, count);
            ans %= MOD;
            ans += recurse(idx + 1, count + 1) * (m - 1);
        }
        return dp[idx][count] = ans % MOD;
        
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
        try (ColorfulBricks instance = new ColorfulBricks()) {
            instance.solve();
        }
    }
}
