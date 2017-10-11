package codeforces.contests101_200.problemset186;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComparingStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        if (x.length != y.length) {
            out.println("NO");return;
        }
        int n = x.length, idx = 0;
        int[] diffs = new int[2];
        for (int i = 0; i < n; i++) {
            if (x[i] != y[i]) {
                if (idx == 2) {
                    out.println("NO");
                    return;
                } else {
                    diffs[idx++] = i;
                }
            }
        }
        boolean ok = x[diffs[0]] == y[diffs[1]] && x[diffs[1]] == y[diffs[0]];
        out.println(ok ? "YES" : "NO");
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
        try (ComparingStrings instance = new ComparingStrings()) {
            instance.solve();
        }
    }
}
