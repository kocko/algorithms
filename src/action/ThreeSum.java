package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        final long MOD = (int) 1e9 + 7;
        long[] dp = new long[n + 1];
        long sn = s(n);
        for (int i = 1; i <= n; i++) {
            dp[i] = (i * (sn - s(i - 1))) % MOD;
        }
        for (int i = n - 1; i >= 1; i--) {
            dp[i] += dp[i + 1];
            dp[i] %= MOD;
        }
        long total = 0;
        for (int i = 1; i <= n; i++) {
            total += ((i * dp[i]) % MOD);
            total %= MOD;
        }
        out.println(total);
    }

    private long s(long n) {
        return (n * (n + 1)) / 2;
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
        try (ThreeSum instance = new ThreeSum()) {
            instance.solve();
        }
    }
}
