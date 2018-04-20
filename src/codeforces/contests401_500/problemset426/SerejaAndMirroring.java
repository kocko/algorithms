package codeforces.contests401_500.problemset426;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerejaAndMirroring implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.ni();
            }
        }
        for (int start = 1; start <= n; start++) {
            if (ok(start)) {
                out.println(start);
                return;
            }
        }
        out.println(n);
    }

    private int n, m;
    private int[][] grid;

    private boolean ok(int start) {
        boolean result = true;
        while (start < n) {
            if (2 * start <= n) result &= check(start);
            else result = false;
            start *= 2;
        }
        return start == n && result;
    }

    private boolean check(int size) {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < m; j++) {
                result &= grid[i][j] == grid[2 * size - i - 1][j];
            }
        }
        return result;
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
        try (SerejaAndMirroring instance = new SerejaAndMirroring()) {
            instance.solve();
        }
    }
}
