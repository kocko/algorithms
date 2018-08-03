package codeforces.contests1001_1100.problemset1016;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class VasyaAndTheMushrooms implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        grid = new long[2][n];
        for (int row = 0; row < 2; row++) {
            for (int i = 0; i < n; i++) {
                grid[row][i] = in.ni();
            }
        }
        out.println(max(straight(), zigzag()));
    }

    private int n;
    private long[][] grid;

    private long straight() {
        long t = 0, result = 0;
        for (int i = 0; i < n; i++) result += grid[0][i] * t++;
        for (int i = n - 1; i >= 0; i--) result += grid[1][i] * t++;
        return result;
    }

    private long zigzag() {
        long t = 0, result = 0;
        int[][] dist = {{1, 0}, {0, 1}, {-1, 0}, {0, 1}};
        int idx = 0;
        int x = 0, y = 0;
        while (t < 2 * n) {
            result += grid[x][y] * t++;
            x += dist[idx][0];
            y += dist[idx][1];
            idx++;
            idx %= 4;
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
        try (VasyaAndTheMushrooms instance = new VasyaAndTheMushrooms()) {
            instance.solve();
        }
    }
}
