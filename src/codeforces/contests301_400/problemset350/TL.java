package codeforces.contests301_400.problemset350;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TL implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int maxOk = 0, minOk = 101;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            maxOk = Math.max(maxOk, next);
            minOk = Math.min(minOk, next);
        }
        int minWrong = 101;
        for (int i = 0; i < m; i++) {
            int next = in.ni();
            minWrong = Math.min(minWrong, next);
        }
        for (int v = maxOk; v < minWrong; v++) {
            if (minOk * 2 <= v) {
                out.println(v);
                return;
            }
        }
        out.println(-1);
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
        try (TL instance = new TL()) {
            instance.solve();
        }
    }
}
