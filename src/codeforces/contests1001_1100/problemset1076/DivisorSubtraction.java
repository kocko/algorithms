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
        long n = in.nl();
        if (n % 2 == 0) {
            out.println(n / 2);
        } else {
            int result = 0;
            while (n > 0) {
                boolean ok = false;
                for (long d : primes) {
                    if (n % d == 0) {
                        n /= d;
                        result++;
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    result++;
                    n = 0;
                }
            }
            out.println(result);
        }
    }

    private List<Long> primes = new ArrayList<>();

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
