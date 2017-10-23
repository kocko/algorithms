package codeforces.contests301_400.problemset365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class TheFibonacciSegment implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(1);
            return;
        }
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        int result = 2, current = 2;
        for (int i = 2; i < n; i++) {
            if (x[i] == x[i - 2] + x[i - 1]) {
                current++;
            } else {
                result = max(result, current);
                current = 2;
            }
        }
        out.println(max(result, current));
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
        try (TheFibonacciSegment instance = new TheFibonacciSegment()) {
            instance.solve();
        }
    }
}
