package hackerrank.contests.weekofcode35;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeDimensionalSurfaceArea implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int h = in.ni(), w = in.ni();
        int result = 2 * w * h;
        int[][] grid = new int[h + 2][w + 2];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                grid[i][j] = in.ni();
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (grid[i][j] > grid[i][j - 1]) {
                    result += grid[i][j] - grid[i][j - 1];
                }
            }
            for (int j = w; j >= 1; j--) {
                if (grid[i][j] > grid[i][j + 1]) {
                    result += grid[i][j] - grid[i][j + 1];
                }
            }
        }
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                if (grid[j][i] > grid[j - 1][i]) {
                    result += grid[j][i] - grid[j - 1][i];
                }
            }
            for (int j = h; j >= 1; j--) {
                if (grid[j][i] > grid[j + 1][i]) {
                    result += grid[j][i] - grid[j + 1][i];
                }
            }
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
        try (ThreeDimensionalSurfaceArea instance = new ThreeDimensionalSurfaceArea()) {
            instance.solve();
        }
    }
}
