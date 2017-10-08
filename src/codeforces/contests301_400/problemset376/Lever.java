package codeforces.contests301_400.problemset376;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lever implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int pivot = -1, n = x.length;
        for (int i = 0; i < n; i++) {
            if (x[i] == '^') {
                pivot = i;
                break;
            }
        }
        long left = 0L, right = 0L;
        for (int i = 1; pivot - i >= 0; i++) {
            if (x[pivot - i] != '=') {
                left += ((long) i * (x[pivot - i] - '0'));
            }
        }
        for (int i = 1; pivot + i < n; i++) {
            if (x[pivot + i] != '=') {
                right += ((long) i * (x[pivot + i] - '0'));
            }
        }
        if (left == right) out.println("balance");
        else if (left > right) out.println("left");
        else out.println("right");
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
        try (Lever instance = new Lever()) {
            instance.solve();
        }
    }
}
