package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NonDivisibleSubset implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] x = new int[k];
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            x[next % k]++;
        }
        long result = 0, additional = 0;
        for (int i = 1; i < k; i++) {
            if (i != k - i) {
                result += Math.max(x[i], x[k - i]);
            } else {
                if (x[i] > 0) {
                    additional = 1;
                }
            }
        }
        result >>= 1;
        if (x[0] > 0) {
            additional++;
        }
        out.println(result + additional);
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
        try (NonDivisibleSubset instance = new NonDivisibleSubset()) {
            instance.solve();
        }
    }
}
