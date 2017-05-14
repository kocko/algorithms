package codeforces.contests101_200.problemset185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Plant implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        if (n == 0) {
            out.println(1);
        } else {
            out.println((fastPower(2L, 2 * n - 1) + fastPower(2, n - 1)) % MOD);
        }
    }
    
    private final long MOD = (long) (1e9 + 7);
    
    private long fastPower(long x, long pow) {
        if (pow == 0) return 1L;
        long half = fastPower(x, pow / 2);
        long squared = (half * half) % MOD;
        return (pow % 2 == 1) ? (squared * x) % MOD : squared;
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
        try (Plant instance = new Plant()) {
            instance.solve();
        }
    }
}
