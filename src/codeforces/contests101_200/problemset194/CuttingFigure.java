package codeforces.contests101_200.problemset194;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class CuttingFigure implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    int p = bfs(new int[]{i, j});
                    if (p != -1) {
                        if (result == -1) {
                            result = p;
                        } else {
                            result = min(result, p);
                        }
                    }
                }
            }
        }
        out.println(result);
    }

    private int n, m;
    private char[][] grid;

    private int bfs(int[] start) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[][] visited = new boolean[n][m];
        int[][] level = new int[n][m];
        level[start[0]][start[1]] = 0;
        visited[start[0]][start[1]] = true;

        int[] count = new int[n * m + 1];
        count[0] = 1;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = 0;
        while (deque.size() > 0) {
            int[] top = deque.pollFirst();
            for (int[] d : dir) {
                int x = top[0] + d[0], y = top[1] + d[1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '#' && !visited[x][y]) {
                    level[x][y] = level[top[0]][top[1]] + 1;
                    max = Math.max(max, level[x][y]);
                    count[level[x][y]]++;
                    visited[x][y] = true;
                    deque.add(new int[]{x, y});
                }
            }
        }
        int result = 10000;
        for (int i = 1; i < max; i++) {
            if (count[i] > 0) {
                result = min(result, count[i]);
            }
        }
        return result == 10000 ? -1 : result;
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
        try (CuttingFigure instance = new CuttingFigure()) {
            instance.solve();
        }
    }
}
