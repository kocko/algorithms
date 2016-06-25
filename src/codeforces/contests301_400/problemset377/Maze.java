package codeforces.contests301_400.problemset377;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Maze implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    int n, m, k, s, count = 0;
    char[][] grid;
    boolean[][] visited;
    
    public void solve() {
        init();
        fill();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && grid[i][j] == '.') {
                    dfs(i, j);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i][j] == '#') {
                    out.print('#');
                } else {
                    if (!visited[i][j]) {
                        out.print("X");    
                    } else {
                        out.print(".");
                    }
                }
            }
            out.println();
        }
    }

    private void init() {
        n = in.ni();
        m = in.ni();
        k = in.ni();
        grid = new char[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (i == 0 || i == n + 1) visited[i][j] = true;
                if (j == 0 || j == m + 1) visited[i][j] = true;
            }
        }
    }
    
    private void fill() {
        for (int i = 1; i <= n; i++) {
            String x = in.next();
            for (int j = 1; j <= m; j++) {
                grid[i][j] = x.charAt(j - 1);
                if (grid[i][j] == '.') s++;
            }
        }
    }
   
    private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void dfs(int i, int j) {
        if (count < s - k) {
            visited[i][j] = true;
            for (int[] d : dir) {
                int x = d[0], y = d[1];
                if (!visited[i + x][j + y] && grid[i + x][j + y] == '.') {
                    count++;
                    dfs(i + x, j + y);
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
        try (Maze instance = new Maze()) {
            instance.solve();
        }
    }
}
