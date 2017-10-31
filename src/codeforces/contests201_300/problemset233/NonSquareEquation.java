package codeforces.contests201_300.problemset233;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NonSquareEquation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        long x = (long) Math.sqrt(n);
        for (long i = x - 100; i <= x; i++) {
            if (i >= 1) {
                if ((digits(i) + i) * i == n) {
                    out.println(i);
                    return;
                }
            }
        }
        out.println(-1);
    }

    private int digits(long x) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x /= 10;
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
        try (NonSquareEquation instance = new NonSquareEquation()) {
            instance.solve();
        }
    }
}
