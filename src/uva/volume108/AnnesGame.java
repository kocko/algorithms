package uva.volume108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnnesGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int test = 1; test <= t; test++) {
            n = in.ni();
            out.printf("Case #%d: ", test);
            if (n == 1) {
                out.println(1);
            } else {
                out.println(power(n - 2));
            }
        }
    }

    private int n;

    private long power(int p) {
        final long MOD = 2000000011;
        if (p == 0) return 1;
        long ans;
        if (p % 2 == 0) {
            long q = power(p / 2) % MOD;
            ans = (q * q);
        } else {
            long q = power(p - 1) % MOD;
            ans = (n * q);
        }
        return ans % MOD;
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
        try (AnnesGame instance = new AnnesGame()) {
            instance.solve();
        }
    }
}
