package codeforces.contests701_800.problemset785;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.min;

public class AntonAndFairyTale implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), m = in.nl();
        if (n <= m) {
            out.println(n);
        } else {
            n -= m;
            long left = 0, right = (long) 2e9;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long value = mid * (mid + 1) / 2;
                if (value >= n) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            out.println(m + left);
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
        try (AntonAndFairyTale instance = new AntonAndFairyTale()) {
            instance.solve();
        }
    }
}
