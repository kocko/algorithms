package codeforces.contests201_300.problemset293;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeirdGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int x = 0, y = 0, draw = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (a[i] == '1' && b[i] == '0') {
                x++;
            } else if (a[i] == '0' && b[i] == '1') {
                y++;
            } else if (a[i] == '1' && b[i] == '1') {
                draw++;
            }
        }
        if (draw % 2 == 1) {
            x++;
        }
        if (x == y || x == y - 1) {
            out.println("Draw");
        } else if (x > y) {
            out.println("First");
        } else {
            out.println("Second");
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
        try (WeirdGame instance = new WeirdGame()) {
            instance.solve();
        }
    }
}
