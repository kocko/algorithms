package codeforces.contests001_100.problemset018;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stripe implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n], prefix = new int[n], suffix = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (i == 0) prefix[i] = x[i];
            else prefix[i] = prefix[i - 1] + x[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) suffix[i] = x[i];
            else suffix[i] = suffix[i + 1] + x[i];
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) result++;
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
        try (Stripe instance = new Stripe()) {
            instance.solve();
        }
    }
}
