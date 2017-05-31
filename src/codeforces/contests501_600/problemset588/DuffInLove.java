package codeforces.contests501_600.problemset588;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DuffInLove implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        Map<Long, Integer> factorization = new HashMap<>();
        for (long i = 2L; i * i <= n; i++) {
            while (n % i == 0) {
                factorization.put(i, factorization.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            factorization.put(n, factorization.getOrDefault(n, 0) + 1);
        }
        long result = 1L;
        for (Long divisor : factorization.keySet()) {
            result *= divisor;
        }
        out.println(result);
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
        try (DuffInLove instance = new DuffInLove()) {
            instance.solve();
        }
    }
}
