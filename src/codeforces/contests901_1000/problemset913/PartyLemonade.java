package codeforces.contests901_1000.problemset913;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.min;

public class PartyLemonade implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = in.ni();
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nl();
        }
        for (int i = 0; i < n - 1; i++) {
            c[i + 1] = min(2 * c[i], c[i + 1]);
        }
        long result = Long.MAX_VALUE, sum = 0L;
        for (int i = n - 1; i >= 0; i--) {
            long times = x / (1L << i);
            sum += times * c[i];
            x -= times << i;
            result = min(result, sum + (x > 0 ? 1 : 0) * c[i]);
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
        try (PartyLemonade instance = new PartyLemonade()) {
            instance.solve();
        }
    }
}
