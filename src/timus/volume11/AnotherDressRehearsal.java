package timus.volume11;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnotherDressRehearsal implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni(), c = in.ni();
        if (x + y < c) {
            out.println("Impossible");
        } else {
            int max = Math.max(x, y), a, b;
            if (c <= max) {
                if (x < y) {
                    a = 0;
                    b = c;
                } else {
                    a = c;
                    b = 0;
                }
            } else {
                if (x < y) {
                    a = c - max;
                    b = max;
                } else {
                    a = max;
                    b = c - max;
                }
            }
            out.println(a + " " + b);
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
        try (AnotherDressRehearsal instance = new AnotherDressRehearsal()) {
            instance.solve();
        }
    }
}
