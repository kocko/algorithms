package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class QueryOnATreeII implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCases = in.ni();
        while (testCases-- > 0) {
            int n = in.ni();
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = in.ni(), v = in.ni(), w = in.ni();
                graph.get(u).add(new Edge(v, w));
                graph.get(v).add(new Edge(u, w));
            }
            depth = new int[n + 1];
            pa = new int[n + 1][15];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(pa[i], -1);
            }
            dist = new int[n + 1][15];
            dis = new int[n + 1];
            visited = new boolean[n + 1];
            dfs(1, -1, 0);
            for (int i = 1; i <= 14; i++) {
                for (int j = 1; j <= n; j++) {
                    if (pa[j][i - 1] != -1) {
                        pa[j][i] = pa[pa[j][i - 1]][i - 1];
                        dist[j][i] = dist[j][i - 1] + dist[pa[j][i - 1]][i - 1];
                    }
                }
            }
            String operation;
            while (!"DONE".equals(operation = in.next())) {
                int u = in.ni(), v = in.ni();
                if ("KTH".equals(operation)) {
                    int k = in.ni();
                    int parent = lca(u, v), d;
                    if (depth[u] - depth[parent] < k) {
                        d = depth[parent] + k - (depth[u] - depth[parent] + 1);
                        u = v;
                    } else {
                        d = depth[u] - k + 1;
                    }
                    out.println(get(u, d));
                } else {
                    out.println(dis[u] + dis[v] - 2 * dis[lca(u, v)]);
                }
            }
            out.println();
        }
    }

    private class Edge {
        private int to, weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private List<List<Edge>> graph;

    private int[] depth;
    private boolean[] visited;
    private int[][] pa;
    private int[][] dist;
    private int[] dis;

    private void dfs(int node, int parent, int d) {
        visited[node] = true;
        pa[node][0] = parent;
        depth[node] = d;

        List<Edge> outgoing = graph.get(node);
        for (Edge edge : outgoing) {
            if (!visited[edge.to]) {
                dist[edge.to][0] = edge.weight;
                dis[edge.to] = dis[node] + edge.weight;
                dfs(edge.to, node, d + 1);
            }
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        for (int i = 14; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = pa[u][i];
            }
        }
        if (u == v) return u;
        for (int i = 14; i >= 0; i--) {
            if (pa[u][i] != -1 && pa[u][i] != pa[v][i]) {
                u = pa[u][i];
                v = pa[v][i];
            }
        }
        return pa[u][0];
    }

    private int get(int u, int d) {
        for (int j = 14; j >= 0; j--)
            if (depth[u] - (1 << j) >= d)
                u = pa[u][j];
        return u;
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
        try (QueryOnATreeII instance = new QueryOnATreeII()) {
            instance.solve();
        }
    }
}
