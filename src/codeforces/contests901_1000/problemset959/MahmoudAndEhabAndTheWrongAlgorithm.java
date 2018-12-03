package codeforces.contests901_1000.problemset959;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MahmoudAndEhabAndTheWrongAlgorithm implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        wa(n);
        ok(n);
    }

    private void wa(int n) {
        if (n <= 5) {
            out.println(-1);
        } else {
            if (n % 2 == 0) {
                for (int v = 2; v <= (n - 2) / 2; v++) {
                    out.println(1 + " " + v);
                }
                int half = n / 2;
                out.println(2 + " " + half);
                for (int v = half + 1; v <= n - 2; v++) {
                    out.println(2 + " " + v);
                }
                out.println(half + " " + (n - 1));
                out.println(half + " " + n);
            } else {
                out.println("1 2");
                int v = 3;
                for (int i = 0; i < (n - 2) / 2; i++) {
                    out.println(1 + " " + v++);
                }
                for (int i = 0; i <= (n - 2) / 2; i++) {
                    out.println(2 + " " + v++);
                }
            }
        }
    }

    private void ok(int n) {
        for (int u = 1; u < n; u++) {
            out.println(u + " " + (u + 1));
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
        try (MahmoudAndEhabAndTheWrongAlgorithm instance = new MahmoudAndEhabAndTheWrongAlgorithm()) {
            instance.solve();
        }
    }
}
