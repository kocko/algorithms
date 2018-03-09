package codeforces.contests901_1000.problemset950;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InterceptedMessage implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.ni();
        }
        int i = 1, j = 1, x = a[0], y = b[0], result = 1;
        while (i < n && j < m) {
            if (x < y) {
                x += a[i++];
            } else if (x > y) {
                y += b[j++];
            } else {
                result++;
                x = a[i++];
                y = b[j++];
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
        try (InterceptedMessage instance = new InterceptedMessage()) {
            instance.solve();
        }
    }
}
