package codeforces.contests501_600.problemset548;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeAndFun implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), q = in.ni();
        int[][] grid = new int[n][m];
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            int current = 0, rowMax = 0; 
            for (int j = 0; j < m; j++) {
                int next = in.ni();
                grid[i][j] = next;
                if (next == 1) {
                    current++;
                } else {
                    rowMax = Math.max(rowMax, current);
                    current = 0;
                }
            }
            row[i] = Math.max(rowMax, current);
        }
        while (q-- > 0) {
            int i = in.ni() - 1, j = in.ni() - 1;
            grid[i][j] ^= 1;
            int current = 0, newMax = 0;
            for (int k = 0; k < m; k++) {
                if (grid[i][k] == 1) {
                    current++;
                } else {
                    newMax = Math.max(newMax, current);
                    current = 0;
                }
            }
            row[i] = Math.max(newMax, current);
            int result = 0;
            for (int k = 0; k < n; k++) {
                result = Math.max(result, row[k]);
            }
            out.println(result);
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
        try (MikeAndFun instance = new MikeAndFun()) {
            instance.solve();
        }
    }
}
