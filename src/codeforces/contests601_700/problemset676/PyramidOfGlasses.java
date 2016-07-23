package codeforces.contests601_700.problemset676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PyramidOfGlasses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    int[][] grid;
    int limit = 2 << 10;
    
    public void solve() {
        int n = in.ni(), t = in.ni();
        grid = new int[n + 1][n + 1];
        for (int i = 0; i < t; i++) {
            fill(2 << 10, 1, 1);
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (grid[j][i] == limit) result++;
            }
        }
        out.println(result);
    }
    
    private void fill(int volume, int x, int y) {
        if (volume != 0) {
            if (grid[x][y] + volume > limit) {
                volume -= (limit - grid[x][y]);
                grid[x][y] = limit;
                if (y < grid.length - 1)
                    fill(volume / 2, x, y + 1);
                if (x < grid.length - 1 && y < grid.length - 1)
                    fill(volume / 2, x + 1, y + 1);
            } else {
                grid[x][y] += volume;
            }
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

    public static void main(String[] args) {
        new PyramidOfGlasses().solve();
    }
}
