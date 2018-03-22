package codeforces.contests901_1000.problemset954;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class StringTyping implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), end = n;
        char[] x = in.next().toCharArray();
        if (n % 2 == 1) {
            end--;
        }
        for (; end >= 0; end -= 2) {
            boolean ok = true;
            int half = end / 2;
            for (int j = 0; j < half; j++) {
                ok &= x[j] == x[j + half];
            }
            if (ok) {
                break;
            }
        }
        int result = (n - end);
        if (end > 0) {
            result += (end / 2) + 1;
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
        try (StringTyping instance = new StringTyping()) {
            instance.solve();
        }
    }
}
