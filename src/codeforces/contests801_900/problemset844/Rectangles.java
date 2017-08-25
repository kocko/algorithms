package codeforces.contests801_900.problemset844;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Rectangles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] grid = new int[n][m];
        int[] rows = new int[n], cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.ni();
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        long result = (long) n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= rows[i]; j++) {
                result += comb(rows[i], j);
            }
            for (int j = 2; j <= m - rows[i]; j++) {
                result += comb(m - rows[i], j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 2; j <= cols[i]; j++) {
                result += comb(cols[i], j);
            }
            for (int j = 2; j <= n - cols[i]; j++) {
                result += comb(n - cols[i], j);
            }
        }
        out.println(result);
    }

    private long comb(long n, long k) {
        if (k == 0) return 1L;
        return (n * comb(n - 1, k - 1)) / k;
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
        try (Rectangles instance = new Rectangles()) {
            instance.solve();
        }
    }
}
