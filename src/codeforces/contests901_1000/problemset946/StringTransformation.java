package codeforces.contests901_1000.problemset946;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.fill;

public class StringTransformation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length, start = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            boolean ok = false;
            for (int j = start; j < n; j++) {
                if (x[j] <= c) {
                    x[j] = c;
                    ok = true;
                    start = j + 1;
                    break;
                }
            }
            if (!ok) {
                out.println(-1);
                return;
            }
        }
        for (char c : x) {
            out.print(c);
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
        try (StringTransformation instance = new StringTransformation()) {
            instance.solve();
        }
    }
}
