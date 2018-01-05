package codeforces.contests401_500.problemset485;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class ValuableResources implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        final long INF = (int) 1e9 + 1;
        long x_min = INF, x_max = -INF;
        long y_min = INF, y_max = -INF;
        for (int i = 0; i < n; i++) {
            long x = in.nl(), y = in.nl();
            x_min = min(x_min, x);
            x_max = max(x_max, x);
            
            y_min = min(y_min, y);
            y_max = max(y_max, y);
        }
        long side = max(x_max - x_min, y_max - y_min);
        out.println(side * side);
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
        try (ValuableResources instance = new ValuableResources()) {
            instance.solve();
        }
    }
}
