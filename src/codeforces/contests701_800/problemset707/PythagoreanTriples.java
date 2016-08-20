package codeforces.contests701_800.problemset707;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PythagoreanTriples implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl();
        if (n <= 2) {
            out.println(-1);
            return;
        }
        long b, c;
        if (n % 2 == 0) {
            b = (n / 2) * (n / 2) - 1;
            c = b + 2;
        } else {
            b = (n * n - 1) / 2;
            c = b + 1;
        }
        out.println(b + " " + c);
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
        try (PythagoreanTriples instance = new PythagoreanTriples()) {
            instance.solve();
        }
    }
}
