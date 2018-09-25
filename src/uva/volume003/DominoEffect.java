package uva.volume003;

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

import static java.lang.Integer.compare;
import static java.util.Arrays.fill;

public class DominoEffect implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        final int oo = (int) 1e9;
        int n, m, test = 1;
        while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni(), w = in.ni();
                graph.get(u).add(new Edge(v, w));
                graph.get(v).add(new Edge(u, w));
            }
            int[] start = new int[n + 1];
            fill(start, oo);

            PriorityQueue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(1, 0));
            start[1] = 0;
            while (!queue.isEmpty()) {
                Edge from = queue.poll();
                for (Edge to : graph.get(from.node)) {
                    if (start[to.node] > start[from.node] + to.weight) {
                        start[to.node] = start[from.node] + to.weight;
                        queue.add(new Edge(to.node, start[to.node]));
                    }
                }
            }
            double result = 0d;
            int[] nodes = {1, -1};
            for (int u = 1; u <= n; u++) {
                for (Edge edge : graph.get(u)) {
                    double time;
                    int min = Math.min(start[u], start[edge.node]);
                    int max = Math.max(start[u], start[edge.node]);
                    if (min + edge.weight > max) {
                        int diff = max - min;
                        time = min + diff + (edge.weight - diff) / 2.;
                        if (time > result) {
                            nodes[0] = u;
                            nodes[1] = edge.node;
                            result = time;
                        }
                    } else {
                        time = min + edge.weight;
                        if (time > result) {
                            nodes[0] = start[u] < start[edge.node] ? edge.node : u;
                            nodes[1] = -1;
                            result = time;
                        }
                    }
                }
            }
            out.printf("System #%d\n", test++);
            if (nodes[1] == -1) {
                out.printf("The last domino falls after %.1f seconds, at key domino %d.\n\n", result, nodes[0]);
            } else {
                out.printf("The last domino falls after %.1f seconds, between key dominoes %d and %d.\n\n", result, nodes[0], nodes[1]);
            }
        }
    }
    
    private class Edge implements Comparable<Edge> {
        private int node, weight;

        private Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return compare(this.weight, o.weight);
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
        try (DominoEffect instance = new DominoEffect()) {
            instance.solve();
        }
    }
}
