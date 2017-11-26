package codeforces.contests401_500.problemset424;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MagicFormulas implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] x = new long[n];
        long xor = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            xor ^= x[i];
        }
        long[] prefix = new long[2000001];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] ^= prefix[i - 1] ^ i;
        }
        for (int i = n; i >= 1; i--) {
            int times = n / i, rem = n % i;
            if (times % 2 == 0) {
                xor ^= prefix[rem];
            } else {
                xor ^= prefix[i - 1];
                xor ^= prefix[rem];
            }
        }
        out.print(xor);
        assert(xor == check(x));
    }

    private long check (long[] data) {
        long result = 0;
        int n = data.length;
        for (int i = 1; i <= n; i++) {
            result ^= data[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result ^= (i % j);
            }
        }
        return result;
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
        try (MagicFormulas instance = new MagicFormulas()) {
            instance.solve();
        }
    }
}
