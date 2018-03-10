package codeforces.contests901_1000.problemset948;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProtectSheep implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int r = in.ni(), c = in.ni();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = in.next().toCharArray();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = 'D';
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean ok = true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'W') {
                    for (int[] d : dir) {
                        if (i + d[0] >= 0 && i + d[0] <= r - 1 && j + d[1] >= 0 && j + d[1] <= c - 1) {
                            ok &= grid[i + d[0]][j + d[1]] != 'S';
                        }
                    }
                }
            }
        }
        if (ok) {
            out.println("Yes");
            for (char[] row : grid) {
                for (char ch : row) {
                    out.print(ch);
                }
                out.println();
            }
        } else {
            out.println("No");
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
        try (ProtectSheep instance = new ProtectSheep()) {
            instance.solve();
        }
    }
}
