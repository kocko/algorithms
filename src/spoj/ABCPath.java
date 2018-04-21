package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ABCPath implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 1;
        while (((h = in.ni()) != 0) & ((w = in.ni()) != 0)) {
            grid = new char[h][w];
            max = new int[h][w];
            for (int i = 0; i < h; i++) {
                grid[i] = in.next().toCharArray();
                for (int j = 0; j < w; j++) {
                    max[i][j] = -1;
                }
            }
            int max = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 'A') {
                        int score = recurse(i, j);
                        if (score > max) max = score;
                    }
                }
            }
            out.printf("Case %d: %d\n", testCase++, max);
        }
    }

    private int h, w;
    private char[][] grid;
    private int[][] max;

    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private int recurse(int row, int col) {
        if (max[row][col] != -1) return max[row][col];

        int ans = 0;
        for (int[] d : dir) {
            if (row + d[0] < h &&
                row + d[0] >= 0 &&
                col + d[1] < w &&
                col + d[1] >= 0 &&
                grid[row + d[0]][col + d[1]] - grid[row][col] == 1) {
                int score = recurse(row + d[0], col + d[1]);
                if (score > ans) ans = score;
            }
        }

        return max[row][col] = ans + 1;
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
        try (ABCPath instance = new ABCPath()) {
            instance.solve();
        }
    }
}
