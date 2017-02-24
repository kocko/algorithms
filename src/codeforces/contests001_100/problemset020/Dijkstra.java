package codeforces.contests001_100.problemset020;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Dijkstra implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int[] prev;
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        final long INF = Long.MAX_VALUE;
        long[] d = new long[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        prev = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            d[i] = INF;
            prev[i] = -1;
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            int u = in.ni(), v = in.ni(), w = in.ni();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        d[1] = 0L;
        while (!queue.isEmpty()) {
            Edge from = queue.poll();
            for (Edge edge : graph.get(from.node)) {
                if (d[edge.node] > d[from.node] + edge.weight) {
                    d[edge.node] = d[from.node] + edge.weight;
                    prev[edge.node] = from.node;
                    queue.add(new Edge(edge.node, d[edge.node] + from.weight));
                }
            }
        }
        if (d[n] == INF) {
            out.println(-1);
        } else {
            out.print(1);
            out.print(' ');
            print(n);
        }
    }
    
    private void print(int node) {
        if (prev[node] != -1) {
            print(prev[node]);
            out.print(node);
            out.print(' ');
        }
    }
    
    private class Edge implements Comparable<Edge> {
        private int node;
        private long weight;
        
        private Edge(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
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
        try (Dijkstra instance = new Dijkstra()) {
            instance.solve();
        }
    }
}
