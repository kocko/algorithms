package codeforces.contests1001_1100.problemset1059;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Forgery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        boolean[][] filled = new boolean[n][m];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i - 1][j - 1] == '#' && grid[i - 1][j] == '#' && grid[i - 1][j + 1] == '#' &&
                    grid[i][j - 1] == '#' && grid[i][j + 1] == '#' &&
                    grid[i + 1][j - 1] == '#' && grid[i + 1][j] == '#' && grid[i + 1][j + 1] == '#') {
                    filled[i - 1][j - 1] = filled[i - 1][j] = filled[i - 1][j + 1] = true;
                    filled[i][j - 1] = filled[i][j + 1] = true;
                    filled[i + 1][j - 1] = filled[i + 1][j] = filled[i + 1][j + 1] = true;
                }
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    ok &= filled[i][j];
                }
            }
        }
        out.println(ok ? "YES" : "NO");
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
        try (Forgery instance = new Forgery()) {
            instance.solve();
        }
    }
}
