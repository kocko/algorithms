package uva.volume109;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleMindedHashing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 1;
        while ((length = in.ni()) != 0 | (sum = in.ni()) != 0) {
            x = new char[length];
            if (length <= 26 && sum <= 351) {
                dp = new Integer[length][sum + 1][27];
                out.printf("Case %d: %d\n", testCase++, recurse(0, 0, 1));
            } else {
                out.printf("Case %d: %d\n", testCase++, 0);
            }
        }
    }

    private int length, sum;
    private Integer[][][] dp;
    private char[] x;

    private Integer recurse(int l, int s, int start) {
        if (l == length) return s == sum ? 1 : 0;
        if (start == 27) return 0;

        if (dp[l][s][start] != null) return dp[l][s][start];

        int ans = 0;
        for (int i = start; i <= 26; i++) {
            if (s + i <= sum) {
                x[l] = (char) ('a' + i - 1);
                ans += recurse(l + 1, s + i, i + 1);
            }
        }
        return dp[l][s][start] = ans;
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
        try (SimpleMindedHashing instance = new SimpleMindedHashing()) {
            instance.solve();
        }
    }
}
