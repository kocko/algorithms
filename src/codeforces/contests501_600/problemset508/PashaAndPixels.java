package codeforces.contests501_600.problemset508;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class PashaAndPixels implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni(), move = 0;
        int[][] grid = new int[n + 2][m + 2];
        for (int i = 1; i <= k; i++) {
            int row = in.ni(), col = in.ni();
            grid[row][col] = 1;
            if ((grid[row - 1][col - 1] == 1 && grid[row][col - 1] == 1 && grid[row - 1][col] == 1) ||
                (grid[row - 1][col] == 1 && grid[row - 1][col + 1] == 1 && grid[row][col + 1] == 1) ||
                (grid[row][col + 1] == 1 && grid[row + 1][col + 1] == 1 && grid[row + 1][col] == 1) ||
                (grid[row + 1][col - 1] == 1 && grid[row][col - 1] == 1 && grid[row + 1][col] == 1)) {
                move = i;
                break;
            }
        }
        out.println(move);
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
        try (PashaAndPixels instance = new PashaAndPixels()) {
            instance.solve();
        }
    }
}
