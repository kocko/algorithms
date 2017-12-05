package codeforces.contests801_900.problemset872;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MaximumSplitting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            out.println(f(in.ni()));
        }
    }

    private int f(int n) {
        if (n == 9) return 1;
        if (n <= 3) return -1;
        if (n % 2 == 0) {
            if (n % 4 == 0) {
                return n / 4;
            } else {
                return (n - 2) / 4;
            }
        } else {
            int rem = f(n - 9);
            if (rem < 0) {
                return -1;
            } else {
                return 1 + rem;
            }
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
        try (MaximumSplitting instance = new MaximumSplitting()) {
            instance.solve();
        }
    }
}
