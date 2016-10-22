package codeforces.contests501_600.problemset567;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class LinelandMail implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] c = new long[n]; 
        for (int i = 0; i < n; i++) {
            c[i] = in.nl();
        }
        for (int i = 0; i < n; i++) {
            long min = 0, max = 0;
            if (i == 0) {
                min = abs(c[1] - c[0]);
                max = abs(c[n - 1] - c[0]);
            } else if (i == n - 1) {
                min = abs(c[n - 1] - c[n - 2]);
                max = abs(c[n - 1] - c[0]);
            } else {
                min = min(abs(c[i - 1] - c[i]), abs(c[i + 1] - c[i]));
                max = max(abs(c[i] - c[0]), abs(c[i] - c[n - 1]));
            }
            out.println(min + " " + max);
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
        try (LinelandMail instance = new LinelandMail()) {
            instance.solve();
        }
    }
}
