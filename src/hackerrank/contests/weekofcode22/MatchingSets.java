package hackerrank.contests.weekofcode22;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MatchingSets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] a = new long[n], b = new long[n];
        long x = 0L;
        for (int i = 0; i < n; i++) {
            a[i] = in.nl();
            x += a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nl();
            x -= b[i];
        }
        if (x == 0) {
            long max = 0L;
            Arrays.sort(a); Arrays.sort(b);
            for (int i = 0; i < n; i++) {
                max += Math.abs(a[i] - b[i]);
            }
            out.println(max / 2);
        } else {
            out.println(-1);
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
        try (MatchingSets instance = new MatchingSets()) {
            instance.solve();
        }
    }
}