package codeforces.contests401_500.problemset404;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Marathon implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        double a = Double.parseDouble(in.next()), d = Double.parseDouble(in.next());
        long n = in.nl();
        for (int i = 1; i <= n; i++) {
            double c = d * i % (4 * a);
            double x, y;
            if (c <= a) {
                x = c; y = 0d;
            } else if (c <= 2 * a) {
                x = a;
                y = c - a;
            } else if (c <= 3 * a) {
                x = 3 * a - c;
                y = a;
            } else {
                x = 0.0;
                y = 4.0 * a - c;
            }
            out.println(x + " " + y);
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
        try (Marathon instance = new Marathon()) {
            instance.solve();
        }
    }
}
