package codeforces.contests301_400.problemset344;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleMolecules implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni(), c = in.ni();
        int x = ~0, y = ~0, z = ~0;
        if ((a - b + c) >= 0 && (a - b + c) % 2 == 0) {
            x = (a - b + c) / 2;
        }
        if ((c - a + b) >= 0 && (c - a + b) % 2 == 0) {
            y = (c - a + b) / 2;
        }
        if ((a + b - c) >= 0 && (a + b - c) % 2 == 0) {
            z = (a + b - c) / 2;
        }
        if (x == ~0 || y == ~0 || z == ~0) {
            out.println("Impossible");
        } else {
            out.println(z + " " + y + " " + x);
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
        try (SimpleMolecules instance = new SimpleMolecules()) {
            instance.solve();
        }
    }
}
