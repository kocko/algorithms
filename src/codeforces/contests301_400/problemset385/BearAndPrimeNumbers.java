package codeforces.contests301_400.problemset385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BearAndPrimeNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        sieve();
        int n = in.ni();
        for (int i = 0; i < n; i++) factorize(in.ni());
        for (int i = 1; i <= MAX; i++) count[i] += count[i - 1];
        int q = in.ni();
        while (q-- > 0) {
            int left = Math.min(MAX, in.ni()), right = Math.min(MAX, in.ni());
            out.println(count[right] - count[left - 1]);
        }
    }

    private final int MAX = (int) 1e7;
    private int[] sieve = new int[MAX + 1];
    private int[] count = new int[MAX + 1];

    private void sieve() {
        for (int i = 0; i <= MAX; i++) sieve[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (sieve[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    sieve[j] = i;
                }
            }
        }
    }

    private void factorize(int n) {
        Set<Integer> factors = new HashSet<>();
        while (n > 1) {
            int factor = sieve[n];
            factors.add(factor);
            n /= factor;
        }
        for (int factor : factors) {
            count[factor]++;
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
        try (BearAndPrimeNumbers instance = new BearAndPrimeNumbers()) {
            instance.solve();
        }
    }
}
