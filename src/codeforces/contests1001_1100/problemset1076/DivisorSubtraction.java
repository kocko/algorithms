package codeforces.contests1001_1100.problemset1076;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DivisorSubtraction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        erathostenes();
        out.println(recurse(in.nl()));
    }

    private List<Long> primes = new ArrayList<>();

    private long recurse(long x) {
        if (x % 2 == 0) {
            return x / 2;
        }
        for (long d : primes) {
            if (x % d == 0) {
                return 1 + recurse(x - d);
            }
        }
        return 1;
    }

    private void erathostenes() {
        int MAX = 100000;
        boolean[] prime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            prime[i] = true;
        }
        for (long i = 2; i * i <= MAX; i++) {
            if (prime[(int) i]) {
                for (long j = i * i; j <= MAX; j += i) {
                    prime[(int) j] = false;
                }
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (prime[i]) primes.add((long) i);
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
        try (DivisorSubtraction instance = new DivisorSubtraction()) {
            instance.solve();
        }
    }
}
