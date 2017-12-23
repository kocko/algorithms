package codeforces.contests901_1000.problemset910;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Integer.max;

public class DoorFrames implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), a = in.ni(), b = in.ni(), result = 6;
        if (4 * a + 2 * b <= n) result = 1;
        else if (2 * a + b <= n) result = 2;
        else if (max(2 * a, 2 * b) <= n || max(2 * b + a, 3 * a) <= n || max(a + b, 2 * a) <= n || max(4 * a, b) <= n) result = 3;
        else if (max(b, 2 * a) <= n || (a + b) <= n) result = 4;
        else if (max(2 * b, a) <= n) result = 5;

        out.println(result);
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
        try (DoorFrames instance = new DoorFrames()) {
            instance.solve();
        }
    }
}
