package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class DistanceQuery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        visited = new boolean[n];
        depth = new int[n];
        pa = new int[n][18];
        min = new int[n][18];
        max = new int[n][18];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        bfs();
        for (int i = 1; i < 18; i++) {
            for (int j = 0; j < n; j++) {
                if (pa[j][i - 1] != -1) {
                    pa[j][i] = pa[pa[j][i - 1]][i - 1];
                    min[j][i] = min(min[j][i - 1], min[pa[j][i - 1]][i - 1]);
                    max[j][i] = max(max[j][i - 1], max[pa[j][i - 1]][i - 1]);
                } else {
                    min[j][i] = min[j][i - 1];
                    max[j][i] = max[j][i - 1];
                }
            }
        }
        int q = in.ni();
        while (q-- > 0) {
            int[] result = lca(in.ni() - 1, in.ni() - 1);
            out.println(result[0] + " " + result[1]);
        }
    }
    
    private class Edge {
        private int to, weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private List<List<Edge>> graph = new ArrayList<>();
    private boolean[] visited;
    private int[][] pa, min, max;
    private int[] depth;

    private void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        pa[0][0] = -1;
        depth[0] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            List<Edge> neighbours = graph.get(node);
            for (Edge edge : neighbours) {
                if (!visited[edge.to]) {
                    min[edge.to][0] = max[edge.to][0] = edge.weight;
                    depth[edge.to] = depth[node] + 1;
                    pa[edge.to][0] = node;
                    queue.add(edge.to);
                }
            }
        }
    }

    private int[] lca(int u, int v) {
        if (depth[u] < depth[v]) {
            u ^= v; v ^= u; u ^= v;
        }
        if (u == v) return new int[]{0, 0};

        int[] result = new int[]{1000005, ~0};
        for (int i = 17; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                result[0] = Math.min(result[0], min[u][i]);
                result[1] = Math.max(result[1], max[u][i]);
                u = pa[u][i];
            }
        }
        if (u == v) return result;
        for (int i = 17; i >= 0; i--) {
            if (pa[u][i] != -1 && pa[u][i] != pa[v][i]) {
                int minValue = Math.min(min[u][i], min[v][i]);
                int maxValue = Math.max(max[u][i], max[v][i]);
                result[0] = Math.min(result[0], minValue);
                result[1] = Math.max(result[1], maxValue);
                u = pa[u][i];
                v = pa[v][i];
            }
        }
        result[0] = Math.min(result[0], Math.min(min[u][0], min[v][0]));
        result[1] = Math.max(result[1], Math.max(max[u][0], max[v][0]));
        return result;
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
        try (DistanceQuery instance = new DistanceQuery()) {
            instance.solve();
        }
    }
}
