package codeforces.contests201_300.problemset228;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheRoadToBerlandIsPavedWithGoodIntentions implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        init(2 * n);
        for (int i = 0; i < m; i++) {
            int a = in.ni() - 1, b = in.ni() - 1, w = in.ni();
            if (w == 0) {
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
        scc();
        boolean possible = true;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < component.length; i += 2) {
            possible &= component[i] != component[i + 1];
            if (component[i] > component[i + 1]) {
                result.add(i / 2);
            }
        }
        if (!possible) {
            out.println("Impossible");
        } else {
            out.println(result.size());
            for (int node : result) {
                out.print(node + 1);
                out.print(' ');
            }
        }
    }

    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private int[] component;
    private boolean[] visited;

    private void init(int n) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        component = new int[n];
        visited = new boolean[n];
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
        try (TheRoadToBerlandIsPavedWithGoodIntentions instance = new TheRoadToBerlandIsPavedWithGoodIntentions()) {
            instance.solve();
        }
    }
}
