package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class AppendAndDelete implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray(), t = in.next().toCharArray();
        int k = in.ni();
        int min = min(s.length, t.length);
        int idx;
        for (idx = 0; idx < min; idx++) {
            if (s[idx] != t[idx]) {
                break;
            }
        }
        int ops = s.length + t.length - 2 * idx;
        boolean result = true;
        if (ops > k) {
            result = false;
        }
        if (ops < k && (k - ops) % 2 == 1) {
            result = false;
        }
        if (idx == 0 && ops < k) {
            result = true;
        }
        if (s.length + t.length <= k) {
            result = true;
        }
        if (ops == 0) {
            result = true;
        }
        out.println(result ? "Yes" : "No");
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
        try (AppendAndDelete instance = new AppendAndDelete()) {
            instance.solve();
        }
    }
}
