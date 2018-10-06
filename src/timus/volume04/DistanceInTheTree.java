package timus.volume14;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Arrays.fill;

public class DistanceInTheTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni(), w = in.ni();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        final int MAX = 50000;
        depth = new int[MAX];
        pa = new int[MAX][17];
        dist = new int[MAX][17];
        
        for (int i = 0; i < n; i++) {
            fill(pa[i], -1);
        }
        visited = new boolean[MAX];
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
            out.println(dist(u, v));
        }
    }
    
    private List<List<Edge>> graph = new ArrayList<>();

    private class Edge {
        private int to, weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    private int[] depth;
    private int[][] pa;
    private int[][] dist;
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
    
    private int dist(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        int result = 0;
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
        try (DistanceInTheTree instance = new DistanceInTheTree()) {
            instance.solve();
        }
    }
}
