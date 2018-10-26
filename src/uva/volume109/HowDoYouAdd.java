package uva.volume109;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HowDoYouAdd implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, k;
        while ((n = in.ni()) != 0 | (k = in.ni()) != 0) {
            dp = new Integer[n + 1][k + 1];
            out.println(recurse(n, k));
        }
    }

    private Integer[][] dp;

    private int recurse(int sum, int remaining) {
        if (remaining == 0) return sum == 0 ? 1 : 0;
        if (dp[sum][remaining] != null) return dp[sum][remaining];

        int ans = 0, MOD = 1000000;
        for (int i = 0; i <= sum; i++) {
            ans += recurse(sum - i, remaining - 1);
            ans %= MOD;
        }
        return dp[sum][remaining] = ans;
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
        try (HowDoYouAdd instance = new HowDoYouAdd()) {
            instance.solve();
        }
    }
}
