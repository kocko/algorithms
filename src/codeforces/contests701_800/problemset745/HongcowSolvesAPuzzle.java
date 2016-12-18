package codeforces.contests701_800.problemset745;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HongcowSolvesAPuzzle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        int minX = 1000, minY = 1000;
        int maxX = -1, maxY = -1;
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    minX = Math.min(i, minX);
                    maxX = Math.max(i, maxX);
                    minY = Math.min(j, minY);
                    maxY = Math.max(j, maxY);
                }
            }
        }
        if (minX * maxX < 0) {
            out.println("NO");
            return;
        }
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (grid[i][j] == '.') {
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
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
        try (HongcowSolvesAPuzzle instance = new HongcowSolvesAPuzzle()) {
            instance.solve();
        }
    }
}
