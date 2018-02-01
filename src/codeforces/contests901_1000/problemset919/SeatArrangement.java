package codeforces.contests901_1000.problemset919;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SeatArrangement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        char[][] grid = new char[n][m];
        char[][] reverse = new char[m][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                reverse[j][i] = grid[i][j];
            }
        }
        int result = count(grid, k);
        if (k > 1) {
            result += count(reverse, k);
        }
        out.println(result);
    }

    private int count(char[][] grid, int target) {
        int result = 0, m = grid[0].length;
        for (char[] row : grid) {
            int current = 0;
            for (int j = 0; j < m; j++) {
                if (row[j] == '.') current++;
                else {
                    if (current >= target) result += (current - target + 1);
                    current = 0;
                }
            }
            if (current >= target) result += (current - target + 1);
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
        try (SeatArrangement instance = new SeatArrangement()) {
            instance.solve();
        }
    }
}
