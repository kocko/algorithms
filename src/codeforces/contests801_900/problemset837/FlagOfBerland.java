package codeforces.contests801_900.problemset837;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FlagOfBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        boolean ok = horizontal(grid) || vertical(grid);
        out.println(ok ? "YES" : "NO");
    }
    
    private boolean horizontal(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n % 3 != 0) return false;
        int limit = n / 3;
        boolean ok = true;
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < m; j++) {
                ok &= grid[i][j] == grid[0][0];
                ok &= grid[limit + i][j] == grid[limit][0];
                ok &= grid[2 * limit + i][j] == grid[2 * limit][0];
            }
        }
        ok &= (grid[0][0] != grid[limit][0] && grid[limit][0] != grid[2 * limit][0] && grid[2 * limit][0] != grid[0][0]);
        return ok;
    }

    private boolean vertical(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (m % 3 != 0) return false;
        int limit = m / 3;
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < limit; j++) {
                ok &= grid[i][j] == grid[0][0];
                ok &= grid[i][limit + j] == grid[0][limit];
                ok &= grid[i][2 * limit + j] == grid[0][2 * limit];
            }
        }
        ok &= (grid[0][0] != grid[0][limit] && grid[0][limit] != grid[0][2 * limit] && grid[0][2 * limit] != grid[0][0]);
        return ok;
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
        try (FlagOfBerland instance = new FlagOfBerland()) {
            instance.solve();
        }
    }
}
