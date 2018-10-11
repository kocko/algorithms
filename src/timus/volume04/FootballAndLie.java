package timus.volume04;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FootballAndLie implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        init(2 * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.ni();
            }
        }
        buildGraph();
        scc();

        boolean[] tellsTheTruth = new boolean[n];
        boolean possible = true;
        for (int i = 0; i < component.length; i += 2) {
            if (component[i] == component[i + 1]) {
                possible = false;
                break;
            }
            tellsTheTruth[i / 2] = component[i] > component[i + 1];
        }
        if (!possible) {
            out.println("Impossible");
            return;
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean liar_i = !tellsTheTruth[i];
                boolean liar_j = !tellsTheTruth[j];
                if (liar_i && liar_j) {
                    if (grid[i][j] == 1)
                        result[j][i] = 3;
                    else if (grid[i][j] == 0)
                        if (grid[j][i] == 0) result[i][j] = result[j][i] = 1;
                        else result[i][j] = 3;
                    else
                        if (grid[j][i] == 1) result[i][j] = 3;
                        else result[j][i] = 3;
                } else if (liar_i) {
                    if (grid[i][j] == 1)
                        result[j][i] = 3;
                    else if (grid[i][j] == 0)
                        if (grid[j][i] == 1) result[i][j] = result[j][i] = 1;
                        else result[i][j] = 3;
                    else if (grid[i][j] == -1)
                        if (grid[j][i] == 0) result[i][j] = 3;
                        else result[i][j] = result[j][i] = 1;
                } else if (liar_j) {
                    if (grid[i][j] == 1)
                        if (grid[j][i] == 0) result[i][j] = result[j][i] = 1;
                        else result[i][j] = 3;
                    else if (grid[i][j] == 0)
                        result[j][i] = 3;
                    else
                        if (grid[j][i] == 0) result[j][i] = 3;
                        else result[i][j] = 3;
                } else {
                    if (grid[i][j] == 1)
                        if (grid[j][i] == 1) result[i][j] = result[j][i] = 1;
                        else result[i][j] = 3;
                    else if (grid[i][j] == 0)
                        result[j][i] = 3;
                    else
                        if (grid[j][i] == 0) result[i][j] = 3;
                        else result[i][j] = result[j][i] = 1;
                }
            }
        }
        print(result);
    }

    private int[][] grid;
    private List<List<Integer>> graph = new ArrayList<>(), reverse = new ArrayList<>();
    private List<Integer> order = new ArrayList<>();
    private boolean[] visited;
    private int[] component;

    private void init(int n) {
        grid = new int[n / 2][n / 2];
        visited = new boolean[n];
        component = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
    }

    private void buildGraph() {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == -1 || grid[j][i] == -1) continue;
                if (grid[i][j] == grid[j][i]) {
                    if (grid[i][j] == 0) {
                        imply(2 * i, not(2 * j));
                        imply(2 * j, not(2 * i));
                    } else {
                        imply(not(2 * i), 2 * j);
                        imply(not(2 * j), 2 * i);
                    }
                }
                else if (grid[i][j] == 0) {
                    imply(2 * i, 2 * j);
                    imply(not(2 * j), not(2 * i));
                } else {
                    imply(2 * j, 2 * i);
                    imply(not(2 * i), not(2 * j));
                }
            }
        }
    }

    private int not(int value) {
        return value ^ 1;
    }

    private void imply(int from, int to) {
        graph.get(from).add(to);
        reverse.get(to).add(from);
    }

    private void scc() {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        int c = 0;
        for (int i = n - 1; i >= 0; i--) {
            int node = order.get(i);
            if (visited[node]) {
                dfs2(node, c++);
            }
        }
    }

    private void dfs1(int u) {
        visited[u] = true;
        for (int v : graph.get(u)) if (!visited[v]) dfs1(v);
        order.add(u);
    }

    private void dfs2(int u, int cmp) {
        visited[u] = false;
        component[u] = cmp;
        for (int v : reverse.get(u)) if (visited[v]) dfs2(v, cmp);
    }

    private void print(int[][] result) {
        for (int[] row : result) {
            for (int value : row) {
                out.print(value);
                out.print(' ');
            }
            out.println();
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
        try (FootballAndLie instance = new FootballAndLie()) {
            instance.solve();
        }
    }
}
