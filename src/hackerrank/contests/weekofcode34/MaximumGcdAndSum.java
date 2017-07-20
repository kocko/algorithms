package hackerrank.contests.weekofcode34;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;

public class MaximumGcdAndSum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        for (int i = 0; i < n; i++) b[i] = in.ni();
        int max = 0, gcd = 0;
        int[] sieve = new int[20];
        fill(sieve, 1);
        for (int i = 0; i < n; i++) {
            if (a[i] != 1) {
                for (int j = a[i]; j < sieve.length; j += a[i]) {
                    sieve[j] = Math.max(a[i], sieve[i]);
                }
            }
        }
        int y = -1;
        for (int i = 0; i < n; i++) {
            if (sieve[b[i]] > gcd) {
                gcd = sieve[b[i]];
                y = b[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (gcd(a[i], y) == gcd) {
                max = Math.max(a[i] + y, max);
            }
        }
        out.println(max);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
        try (MaximumGcdAndSum instance = new MaximumGcdAndSum()) {
            instance.solve();
        }
    }
}
