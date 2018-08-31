package uva.volume115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Dominos implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            graph = new ArrayList<>();
            reverse = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                reverse.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni() - 1, v = in.ni() - 1;
                graph.get(u).add(v);
                reverse.get(v).add(u);
            }
            order = new ArrayList<>();
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs1(i);
                }
            }
            component = new ArrayList<>();
            List<List<Integer>> components = new ArrayList<>();
            int[] idx = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int node = order.get(n - i - 1);
                if (!visited[node]) {
                    component.clear();
                    dfs2(node);
                    for (int v : component) idx[v] = components.size();
                    components.add(new ArrayList<>(component));
                }
            }
            int[] degree = new int[components.size()];
            for (int u = 0; u < n; u++) {
                for (int v : graph.get(u)) {
                    if (idx[u] != idx[v]) {
                        degree[idx[v]]++;
                    }
                }
            }
            int result = 0;
            for (int deg : degree) {
                if (deg == 0) result++;
            }
            out.println(result);
        }
    }
    
    private List<List<Integer>> graph;
    private List<List<Integer>> reverse;
    private List<Integer> order, component;
    private boolean[] visited;
    
    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        order.add(node);
    }
    
    private void dfs2(int node) {
        visited[node] = true;
        component.add(node);
        for (int next : reverse.get(node)) {
            if (!visited[next]) {
                dfs2(next);
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
        try (Dominos instance = new Dominos()) {
            instance.solve();
        }
    }
}
