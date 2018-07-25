package codeforces.contests1001_1100.problemset1006;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class XorPaths implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        k = in.nl();
        x = new long[n][m];
        limit = min(m, n) - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = in.nl();
            }
        }
        left(0, 0, 0);
        right(n - 1, m - 1, 0);
        out.println(result);
    }

    private int limit;
    private long k, result;
    private long[][] x;
    private Map<Integer, Map<Long, Long>> map = new HashMap<>();

    private void left(int i, int j, long xor) {
        if (i + j == limit) {
            int idx = index(i, j);
            Map<Long, Long> map = this.map.getOrDefault(idx, new HashMap<>());
            Long key = xor ^ x[i][j];
            map.put(key, map.getOrDefault(key, 0L) + 1);
            this.map.put(idx, map);
        } else {
            left(i + 1, j, xor ^ x[i][j]);
            left(i, j + 1, xor ^ x[i][j]);
        }
    }

    private void right(int i, int j, long xor) {
        if (i + j == limit) {
            int idx = index(i, j);
            Map<Long, Long> map = this.map.getOrDefault(idx, new HashMap<>());
            long need = xor ^ k;
            result += map.getOrDefault(need, 0L);
        } else {
            if (j > 0) right(i, j - 1, xor ^ x[i][j]);
            if (i > 0) right(i - 1, j, xor ^ x[i][j]);
        }
    }

    private int index(int i, int j) {
        return i * (limit + 1) + j + 1;
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
        try (XorPaths instance = new XorPaths()) {
            instance.solve();
        }
    }
}