package codeforces.contests801_900.problemset811;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VladikAndComplicatedBook implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.ni();
        }
        while (m-- > 0) {
            int x = in.ni() - 1, y = in.ni() - 1, idx = in.ni() - 1;
            int less = 0;
            for (int i = x; i <= y; i++) {
                if (p[i] < p[idx]) less++;
            }
            int pos = x + less;
            out.println((pos == idx) ? "Yes" : "No");
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
        try (VladikAndComplicatedBook instance = new VladikAndComplicatedBook()) {
            instance.solve();
        }
    }
}
