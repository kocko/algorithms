package uva.volume114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Squares implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] dp = new int[10001];
        fill(dp, 4);
        for (int i = 1; i <= 100; i++) dp[i * i] = 1;
        dp[0] = 0;
        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[j] == 1) {
                    dp[i] = min(dp[i], dp[i - j] + 1);
                }
            }
        }

        int q = in.ni();
        while (q-- > 0) {
            out.println(dp[in.ni()]);
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
        try (Squares instance = new Squares()) {
            instance.solve();
        }
    }
}
