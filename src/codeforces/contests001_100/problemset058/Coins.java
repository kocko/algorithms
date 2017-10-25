package codeforces.contests001_100.problemset058;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Coins implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int MAX = 1000000;
        int[] sieve = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) sieve[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (sieve[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    sieve[j] = i;
                }
            }
        }
        int n = in.ni();
        while (n > 1) {
            out.print(n);
            out.print(' ');
            n /= sieve[n];
        }
        out.print(n);
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
        try (Coins instance = new Coins()) {
            instance.solve();
        }
    }
}
