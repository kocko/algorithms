package uva.volume122;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AntsColony implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int u = 1; u < n; u++) {
                int v = in.ni();
                long w = in.nl();
                graph.get(u).add(new Edge(v, w));
                graph.get(v).add(new Edge(u, w));
            }
            pa = new int[n][17];
            dist = new long[n][17];
            visited = new boolean[n];
            depth = new int[n];
            dfs(0, -1, 0);
            for (int i = 1; i <= 16; i++) {
                for (int j = 0; j < n; j++) {
                    if (pa[j][i - 1] != -1) {
                        pa[j][i] = pa[pa[j][i - 1]][i - 1];
                        dist[j][i] = dist[pa[j][i - 1]][i - 1] + dist[j][i - 1];
                    }
                }
            }
            int q = in.ni();
            while (q-- > 0) {
                int u = in.ni(), v = in.ni();
                out.print(lca(u, v));
                if (q > 0) out.print(' ');
            }
            out.println();
        }
    }
    
    private class Edge {
        private int to;
        private long weight;

        private Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    private List<List<Edge>> graph;
    private int[] depth;
    private int[][] pa;
    private long[][] dist;
    private boolean[] visited;
    
    private void dfs(int node, int parent, int d) {
        visited[node] = true;
        pa[node][0] = parent;
        depth[node] = d;
        
        List<Edge> outgoing = graph.get(node);
        for (Edge edge : outgoing) {
            if (!visited[edge.to]) {
                dist[edge.to][0] = edge.weight;
                dfs(edge.to, node, d + 1);
            }
        }
    }
    
    private long lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        long result = 0;
        for (int i = 16; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                result += dist[u][i];
                u = pa[u][i];
            }
        }
        if (u == v) return result;
        for (int i = 16; i >= 0; i--) {
            if (pa[u][i] != -1 && pa[u][i] != pa[v][i]) {
                result += dist[u][i] + dist[v][i];
                u = pa[u][i];
                v = pa[v][i];
            }
        }
        return result + dist[u][0] + dist[v][0];
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
        try (AntsColony instance = new AntsColony()) {
            instance.solve();
        }
    }
}
