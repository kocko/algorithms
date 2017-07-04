package csadademy.problemset031;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RecursiveString implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        dp[0] = dp[1] = dp[2] = 1;
        for (int i = 3; i < 36; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        char ans = recurse(n, k);
        if (ans == '?') {
            out.println(-1);
        } else {
            out.println(ans);
        }
    }
    
    private int[] dp = new int[36];
    
    private char recurse(int n, int k) {
        if (n <= 2) {
            if (k == 1) {
                return (char) ('a' + n);
            } else return '?';
        }
        if (k > dp[n - 1] + dp[n - 2]) {
            return recurse(n - 3, k - dp[n - 1] - dp[n - 2]);
        } else if (k > dp[n - 1]) {
            return recurse(n - 2, k - dp[n - 1]);
        } else {
            return recurse(n - 1, k);
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
        try (RecursiveString instance = new RecursiveString()) {
            instance.solve();
        }
    }
}
