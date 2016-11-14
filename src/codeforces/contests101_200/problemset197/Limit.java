package codeforces.contests101_200.problemset197;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Limit implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private static final String MIN_INF = "-Infinity";
    private static final String INF = "Infinity";
    private static final String ZERO = "0/1";
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] a = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            a[i] = in.ni();
        }
        int[] b = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            b[i] = in.ni();
        }
        if (n > m) {
            out.println((a[0] * b[0]) > 0 ? INF : MIN_INF);
        } else if (n < m) {
            out.println(ZERO);
        } else {
            int d = gcd(a[0], b[0]);
            boolean positive = a[0] * b[0] > 0;
            if (!positive) {
                out.print("-");
            }
            out.println(Math.abs(a[0]) / Math.abs(d) + "/" + Math.abs(b[0]) / Math.abs(d));
        }
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
        try (Limit instance = new Limit()) {
            instance.solve();
        }
    }
}
