package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Cheating implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        List<List<Edge>> graph = new ArrayList<>();
        int[] dist = new int[n + 1];
        final int oo = (int) 1e9;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = oo;
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(new Edge(v, 0));
            graph.get(v).add(new Edge(u, 0));
        }
        for (int i = 0; i < k; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(new Edge(v, 1));
            graph.get(v).add(new Edge(u, 1));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        dist[1] = 0;
        while (queue.size() > 0) {
            Edge v = queue.poll();
            for (Edge edge : graph.get(v.node)) {
                if (dist[edge.node] > dist[v.node] + edge.weight) {
                    dist[edge.node] = dist[v.node] + edge.weight;
                    queue.offer(new Edge(edge.node, dist[edge.node]));
                }
            }
        }
        out.println(dist[n] == oo ? -1 : dist[n]);
    }

    private class Edge implements Comparable<Edge> {
        private int node, weight;

        private Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
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
        try (Cheating instance = new Cheating()) {
            instance.solve();
        }
    }
}
