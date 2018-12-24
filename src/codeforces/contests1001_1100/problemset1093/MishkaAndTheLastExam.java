package codeforces.contests1001_1100.problemset1093;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MishkaAndTheLastExam implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] a = new long[n], b = new long[n / 2];
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nl();
        }
        long min = 0, max = b[0];
        for (int i = 0; i < b.length; i++) {
            if (min + max == b[i]) {
                a[i] = min;
                a[n - i - 1] = max;
            } else if (min + max > b[i]) {
                a[i] = a[i - 1];
                a[n - i - 1] = b[i] - a[i];
            } else {
                a[n - i - 1] = a[n - i];
                a[i] = b[i] - a[n - i - 1];
            }
            min = a[i];
            max = a[n - i - 1];
        }
        for (long value : a) {
            out.print(value);
            out.print(' ');
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
        try (MishkaAndTheLastExam instance = new MishkaAndTheLastExam()) {
            instance.solve();
        }
    }
}
