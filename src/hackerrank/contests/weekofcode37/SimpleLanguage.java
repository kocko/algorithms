package hackerrank.contests.weekofcode37;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SimpleLanguage implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] prefix = new long[n];
        long[] set = new long[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) prefix[i] = prefix[i - 1];
            String operation = in.next();
            long value = in.ni();
            if (value > 0) {
                if ("add".equals(operation)) {
                    prefix[i] += value;
                } else {
                    set[i] = value;
                }
            }
        }
        long max = prefix[n - 1];
        for (int i = 0; i < n; i++) {
            if (set[i] > 0) {
                max = max(max, set[i] + (prefix[n - 1] - prefix[i]));
            }
        }
        out.println(max);
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
        try (SimpleLanguage instance = new SimpleLanguage()) {
            instance.solve();
        }
    }
}
