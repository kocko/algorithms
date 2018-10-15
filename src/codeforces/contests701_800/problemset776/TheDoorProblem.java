package codeforces.contests701_800.problemset776;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheDoorProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] r = new int[n];
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            r[i] = in.ni();
            rooms.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int count = in.ni();
            for (int j = 0; j < count; j++) {
                rooms.get(in.ni() - 1).add(i);
            }
        }
        init(2 * m);
        buildGraph(r, rooms);
        scc();
        solve2sat();
    }

    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private boolean[] visited;
    private int[] component;

    private void init(int size) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        visited = new boolean[size];
        component = new int[size];
    }

    private void buildGraph(int[] r, List<List<Integer>> rooms) {
        int n = rooms.size();
        for (int i = 0; i < n; i++) {
            int a = rooms.get(i).get(0), b = rooms.get(i).get(1);
            if (r[i] == 0) {
                imply(not(2 * a), 2 * b);
                imply(2 * a, not(2 * b));
                imply(not(2 * b), 2 * a);
                imply(2 * b, not(2 * a));
            } else {
                imply(2 * a, 2 * b);
                imply(not(2 * a), not(2 * b));
                imply(2 * b, 2 * a);
                imply(not(2 * b), not(2 * a));
            }
        }
    }

    private void imply(int u, int v) {
        graph.get(u).add(v);
        reverse.get(v).add(u);
    }

    private int not(int value) {
        return value ^ 1;
    }

    private void scc() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        int c = 0;
        for (int i = order.size() - 1; i >= 0; i--) {
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

    private void solve2sat() {
        boolean solvable = true;
        for (int i = 0; i < component.length; i += 2) {
            solvable &= component[i] != component[i + 1];
        }
        out.println(solvable ? "YES" : "NO");
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
        try (TheDoorProblem instance = new TheDoorProblem()) {
            instance.solve();
        }
    }
}
