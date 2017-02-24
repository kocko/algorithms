package hackerrank.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class DijkstraShortestReach2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        final int INF = Integer.MAX_VALUE;
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            int[] d = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                d[i] = INF;
            }
            int[][] adj = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    adj[i][j] = INF;
                }
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni(), w = in.ni();
                adj[u][v] = Math.min(adj[u][v], w);
                adj[v][u] = Math.min(adj[v][u], w);
            }
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (adj[i][j] != INF) {
                        graph.get(i).add(new Edge(j, adj[i][j]));
                        graph.get(j).add(new Edge(i, adj[i][j]));
                    }
                }
            }
            int start = in.ni();
            Queue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(start, 0));
            boolean[] visited = new boolean[n + 1];
            while (!queue.isEmpty()) {
                Edge top = queue.poll();
                int from = top.to;
                int weight = top.weight;
                visited[from] = true;
                for (Edge edge : graph.get(from)) {
                    if (!visited[edge.to]) {
                        if (d[edge.to] > edge.weight + weight) {
                            d[edge.to] = edge.weight + weight;
                            queue.add(new Edge(edge.to, edge.weight + weight));
                        }
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if (i != start) {
                    out.print((d[i] == INF ? -1 : d[i]) + " ");
                }
            }
            out.println();
        }
    }

    private class Edge implements Comparable<Edge> {
        private int to;
        private int weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Edge) {
                Edge cast = (Edge) obj;
                return this.to == cast.to;
            }
            return false;
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
        try (DijkstraShortestReach2 instance = new DijkstraShortestReach2()) {
            instance.solve();
        }
    }
}
