package codeforces.contests1101_1200.problemset1101;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Accordion implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        boolean[] remove = new boolean[n];
        int open = -1, close = -1, a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (x[i] != '[') {
                remove[i] = true;
            } else {
                open = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (x[i] != ']') {
                remove[i] = true;
            } else {
                close = i;
                break;
            }
        }
        int result = -1;
        if (open >= 0 && close >= 0 && open < close) {
            for (int i = open + 1; i < close; i++) {
                if (x[i] == ':') {
                    a = i;
                    break;
                } else remove[i] = true;
            }
            for (int i = close - 1; i > open; i--) {
                if (x[i] == ':') {
                    b = i;
                    break;
                } else {
                    remove[i] = true;
                }
            }
            if (a >= 0 && b >= 0 && a != b) {
                for (int i = a + 1; i < b; i++) {
                    if (x[i] != '|') remove[i] = true;
                }
                result = 0;
                for (int i = 0; i < n; i++) {
                    if (!remove[i]) result++;
                }
            }
        }
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
        try (Accordion instance = new Accordion()) {
            instance.solve();
        }
    }
}
