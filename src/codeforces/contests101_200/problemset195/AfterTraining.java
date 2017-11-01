package codeforces.contests101_200.problemset195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AfterTraining implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] result = new int[m];
        int left, right, idx = 0;
        if (m % 2 == 1) {
            left = right = (m + 1) / 2;
        } else {
            left = m / 2;
            right = left + 1;
        }
        while (idx < m) {
            if (left != right) {
                result[idx++] = left--;
                result[idx++] = right++;
            } else {
                result[idx++] = left--;
                right++;
            }
        }
        idx = 0;
        for (int i = 0; i < n; i++) {
            out.println(result[idx++]);
            if (idx == m) idx = 0;
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
        try (AfterTraining instance = new AfterTraining()) {
            instance.solve();
        }
    }
}
