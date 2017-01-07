package codeforces.contests701_800.problemset750;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearAndFireworks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final int[][] dir = {
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1}
    };
    
    private boolean[][] grid = new boolean[400][400];
    private boolean[][][][] vis = new boolean[32][400][400][8];
    
    private int[] t;
    private int result;
    
    private void recurse(int idx, int x, int y, int d) {
        if (idx == t.length) return;
        if (vis[idx][x][y][d]) return;
        
        vis[idx][x][y][d] = true;
        for (int i = 0; i < t[idx]; i++) {
            x += dir[d][0];
            y += dir[d][1];
            if (!grid[x][y]) {
                result++;
            }
            grid[x][y] = true;
        }
        recurse(idx + 1, x, y, (d + 1) % 8);
        recurse(idx + 1, x, y, (d + 7) % 8);
    }

    public void solve() {
        int n = in.ni();
        t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.ni();
        }
        recurse(0, 200, 200, 0);
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
        try (NewYearAndFireworks instance = new NewYearAndFireworks()) {
            instance.solve();
        }
    }
}
