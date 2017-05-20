package codeforces.contests801_900.problemset810;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class DoYouWantADate implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private long[] pow = new long[300001];
    private final long MOD = (long) 1e9 + 7;

    public void solve() {
        init();
        int n = in.ni();
        int x[] = new int[n + 1];
        for (int i = 1; i <= n; i++) x[i] = in.ni();
        sort(x, 1, n + 1);
        long result = 0;
        for (int i = 1; i <= n; i++) {
            long a = (pow[i - 1] * x[i]) % MOD;
            long b = (pow[n - i] * x[i]) % MOD;
            result += (a - b + MOD) % MOD;
            result %= MOD;
        }
        out.println(result);
    }

    private void init() {
        pow[0] = 1L;
        for (int i = 1; i < pow.length ; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
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
        try (DoYouWantADate instance = new DoYouWantADate()) {
            instance.solve();
        }
    }
}
