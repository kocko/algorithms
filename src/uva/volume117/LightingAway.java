package uva.volume117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LightingAway implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), m = in.ni();
            reset(n);
            for (int i = 0; i < m; i++) {
                int u = in.ni() - 1, v = in.ni() - 1;
                graph.get(u).add(v);
                reverse.get(v).add(u);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) dfs1(i);
            }
            int c = 0;
            for (int i = n - 1; i >= 0; i--) {
                int node = order.get(i);
                if (visited[node]) {
                    dfs2(node, c++);
                }
            }
            int[] degree = new int[c];
            for (int u = 0; u < n; u++) {
                for (int v : graph.get(u)) {
                    if (component[u] != component[v]) degree[component[v]]++;
                }
            }
            int result = 0;
            for (int i = 0; i < c; i++) {
                if (degree[i] == 0) result++;
            }

            out.printf("Case %d: %d\n", testCase, result);
        }
    }

    private void reset(int n) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        order = new ArrayList<>();
        visited = new boolean[n];
        component = new int[n];
    }

    private List<List<Integer>> graph = new ArrayList<>(), reverse = new ArrayList<>();
    private List<Integer> order;
    private boolean[] visited;
    private int[] component;

    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        order.add(node);
    }

    private void dfs2(int node, int c) {
        visited[node] = false;
        component[node] = c;
        for (int next : reverse.get(node)) {
            if (visited[next]) {
                dfs2(next, c);
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
        try (LightingAway instance = new LightingAway()) {
            instance.solve();
        }
    }
}
