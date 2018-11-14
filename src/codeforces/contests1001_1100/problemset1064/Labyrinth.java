package codeforces.contests1001_1100.problemset1064;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Labyrinth implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        m = in.ni();
        int r = in.ni() - 1, c = in.ni() - 1;
        int left = in.ni(), right = in.ni();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        visited = new boolean[n][m];
        bfs(r, c, left, right);
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    result++;
                }
            }
        }
        out.println(result);
    }

    private int n, m;
    private char[][] grid;
    private boolean[][] visited;

    private void bfs(int row, int col, int left, int right) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(row, col, left, right));

        while (!queue.isEmpty()) {
            State top = queue.pollFirst();
            if (visited[top.row][top.col]) continue;

            int max = top.row;
            for (int i = top.row; i < n; i++) {
                if (grid[i][top.col] == '.') {
                    visited[i][top.col] = true;
                    max = i;
                } else break;
            }
            int min = top.row;
            for (int i = top.row; i >= 0; i--) {
                if (grid[i][top.col] == '.') {
                    visited[i][top.col] = true;
                    min = i;
                } else break;
            }
            for (int r = min; r <= max; r++) {
                if (top.left > 0) {
                    int c = top.col - 1;
                    if (c >= 0 && grid[r][c] == '.') {
                        queue.add(new State(r, c, top.left - 1, top.right));
                    }
                }
                if (top.right > 0) {
                    int c = top.col + 1;
                    if (c < m && grid[r][c] == '.') {
                        queue.add(new State(r, c, top.left, top.right - 1));
                    }
                }
            }
        }
    }

    private class State {
        private int row, col, left, right;

        private State(int row, int col, int left, int right) {
            this.row = row;
            this.col = col;
            this.left = left;
            this.right = right;
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
        try (Labyrinth instance = new Labyrinth()) {
            instance.solve();
        }
    }
}
