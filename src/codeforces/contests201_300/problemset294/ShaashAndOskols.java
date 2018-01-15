package codeforces.contests201_300.problemset294;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShaashAndOskols implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] wire = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wire[i] = in.ni();
        }
        int s = in.ni();
        while (s-- > 0) {
            int w = in.ni(), idx = in.ni();
            if (w >= 2) {
                wire[w - 1] += idx - 1;
            }
            if (w <= n - 1) {
                wire[w + 1] += wire[w] - idx;
            }
            wire[w] = 0;
        }
        for (int i = 1; i <= n; i++) {
            out.println(wire[i]);
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
        try (ShaashAndOskols instance = new ShaashAndOskols()) {
            instance.solve();
        }
    }
}
