package codeforces.contests101_200.problemset152;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PocketBook implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[][] has = new boolean[m][26];
        for (int i = 0; i < n; i++) {
            char[] next = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                has[j][next[j] - 'A'] = true;
            }
        }
        long result = 1L, MOD = (long) 1e9 + 7;
        for (int i = 0; i < m; i++) {
            long count = 0;
            for (int j = 0; j < 26; j++) {
                if (has[i][j]) count++;
            }
            result *= count;
            result %= MOD;
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
        try (PocketBook instance = new PocketBook()) {
            instance.solve();
        }
    }
}
