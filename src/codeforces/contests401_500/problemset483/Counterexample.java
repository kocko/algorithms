package codeforces.contests401_500.problemset483;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Counterexample implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long left = in.nl(), right = in.nl();
        for (long a = left; a <= right; a++) {
            for (long b = a + 1; b <= right; b++) {
                for (long c = b + 1; c <= right; c++) {
                    if (gcd(a, b) == 1 && gcd(b, c) == 1 && gcd(a, c) != 1) {
                        out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }
        out.println(~0);
    }
    
    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
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
        try (Counterexample instance = new Counterexample()) {
            instance.solve();
        }
    }
}
