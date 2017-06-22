package codeforces.contests401_500.problemset447;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DZYLovesStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int k = in.ni();
        long[] w = new long[26];
        long max = 0;
        for (int i = 0; i < 26; i++) {
            w[i] = in.ni();
            if (w[i] > max) max = w[i];
        }
        long value = 0;
        int i;
        for (i = 1; i <= x.length; i++) {
            value += i * w[x[i - 1] - 'a'];
        }
        for (int j = 0; j < k; j++) {
            value += i * max;
            i++;
        }
        out.println(value);
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
        try (DZYLovesStrings instance = new DZYLovesStrings()) {
            instance.solve();
        }
    }
}
