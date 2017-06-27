package codeforces.contests401_500.problemset474;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flowers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int t = in.ni(), k = in.ni();
        final int MAX = 100001, MOD = (int) 1e9 + 7;
        int[] dp = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            if (i < k) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - k] + dp[i - 1]) % MOD;
            }
        }
        for (int i = 1; i < MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i]) % MOD; 
        }
        while (t-- > 0) {
            int a = in.ni(), b = in.ni();
            out.println((dp[b] - dp[a - 1] + MOD) % MOD);
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
        try (Flowers instance = new Flowers()) {
            instance.solve();
        }
    }
}
