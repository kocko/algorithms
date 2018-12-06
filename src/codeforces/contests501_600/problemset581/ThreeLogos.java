package codeforces.contests501_600.problemset581;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class ThreeLogos implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] x = new int[3], y = new int[3];
        int side = 0, idx = -1, area = 0;
        for (int i = 0; i < 3; i++) {
            x[i] = in.ni();
            y[i] = in.ni();
            area += (x[i] * y[i]);
            int mx = max(x[i], y[i]);
            if (mx > side) {
                side = mx;
                idx = i;
            }
        }
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt != area) {
            out.println(-1);
            return;
        }
        char[][] grid = new char[side][side];

        int other = x[idx] ^ y[idx] ^ side;
        boolean possible = true;
        possible &= fill(grid, (char) ('A' + idx), other, side);

        other = side - other;
        ArrayDeque<Integer> remaining = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            if (i != idx) {
                remaining.offerLast(i);
            }
        }
        while (!remaining.isEmpty()) {
            int top = remaining.pollFirst();
            boolean consumed = false;
            if (x[top] == other || y[top] == other) {
                int p = x[top] ^ y[top] ^ other;
                consumed = fill(grid, (char) ('A' + top), other, p);
            } else if (x[top] == side || y[top] == side) {
                int o = x[top] ^ y[top] ^ side;
                consumed = fill(grid, (char) ('A' + top), o, side);
            }
            possible &= consumed;
        }
        if (possible) {
            out.println(side);
            for (char[] row : grid) {
                for (char c : row) {
                    out.print(c);
                }
                out.println();
            }
        } else {
            out.println(-1);
        }
    }

    private boolean fill(char[][] grid, char letter, int rows, int cols) {
        int r = 0, c = 0, n = grid.length;
        out: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0x0000) {
                    r = i;
                    c = j;
                    break out;
                }
            }
        }
        for (int i = r; i < r + rows; i++) {
            for (int j = c; j < c + cols; j++) {
                if (i == n || j == n) return false;
                grid[i][j] = letter;
            }
        }
        return true;
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
        try (ThreeLogos instance = new ThreeLogos()) {
            instance.solve();
        }
    }
}
