package codeforces.contests501_599.problemset598;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IgorInTheMuseum implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    char[][] grid;
    int[][] component;
    int[] result;
    boolean[][] visited;

    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        grid = new char[n][m];
        visited = new boolean[n][m];
        component = new int[n][m];
        result = new int[n * m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '.') {
                    id++;
                    dfs(i, j, id);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            int x = in.ni() - 1, y = in.ni() - 1;
            out.println(result[component[x][y]]);
        }
    }

    private void dfs(int i, int j, int id) {
        component[i][j] = id;
        if (!visited[i][j]) {
            visited[i][j] = true;
            for (int[] d : dir) {
                int x = d[0] + i, y = d[1] + j;
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (grid[x][y] == '*') {
                        result[id]++;
                    } else if (grid[x][y] == '.') {
                        dfs(x, y, id);
                    }
                }
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

    public static void main(String[] args) throws IOException {
        try (IgorInTheMuseum instance = new IgorInTheMuseum()) {
            instance.solve();
        }
    }
}