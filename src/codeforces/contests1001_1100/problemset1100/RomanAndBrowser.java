package codeforces.contests1001_1100.problemset1100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class RomanAndBrowser implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            type[i] = in.ni();
        }
        int result = 0;
        for (int b = 0; b < n; b++) {
            boolean[] closed = new boolean[n];
            int start = b % k;
            for (; start < n; start += k) {
                closed[start] = true;
            }
            int e = 0, s = 0;
            for (int i = 0; i < n; i++) {
                if (!closed[i]) {
                    if (type[i] == 1) e++;
                    else s++;
                }
            }
            result = max(result, abs(s - e));
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
        try (RomanAndBrowser instance = new RomanAndBrowser()) {
            instance.solve();
        }
    }
}
