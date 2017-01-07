package codeforces.contests301_400.problemset363;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FixingTypos implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        char[] first = new char[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i < 2) first[idx++] = x[i];
            else {
                if (x[i] != x[i - 1] || x[i - 1] != x[i - 2]) {
                    first[idx++] = x[i];
                }
            }
        }
        char[] result = new char[idx];
        int k = 0;
        for (int i = 0; i < idx; i++) {
            if (i < 3) result[k++] = first[i];
            else {
                if (first[i] != result[k - 1] || result[k - 2] != result[k - 3]) {
                    result[k++] = first[i];
                }
            }
        }
        for (int i = 0; i < k; i++) {
            out.print(result[i]);
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
        try (FixingTypos instance = new FixingTypos()) {
            instance.solve();
        }
    }
}
