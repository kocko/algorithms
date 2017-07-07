package codeforces.contests501_600.problemset570;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Replacement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        char[] x = in.next().toCharArray();
        int score = 0;
        for (int i = 0; i < n - 1; i++) {
            if (x[i] == '.' && x[i + 1] == '.') {
                score++;
            }
        }
        while (q-- > 0) {
            int idx = in.ni() - 1;
            char value = in.next().charAt(0);
            if (x[idx] == '.' && value != '.') {
                if (idx > 0 && x[idx - 1] == '.') score--;
                if (idx < n - 1 && x[idx + 1] == '.') score--;
            } else if (x[idx] != '.' && value == '.') {
                if (idx > 0 && x[idx - 1] == '.') score++;
                if (idx < n - 1 && x[idx + 1] == '.') score++;
            }
            out.println(score);
            x[idx] = value;
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
        try (Replacement instance = new Replacement()) {
            instance.solve();
        }
    }
}
