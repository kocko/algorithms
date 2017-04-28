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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumSpanningTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Pair implements Comparable<Pair> {
        int to;
        long weight;

        private Pair(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    private List<Pair>[] adj;
    boolean[] marked;

    public void solve() {
        int n = in.ni(), m = in.ni();
        adj = new List[n + 1];
        marked = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = in.ni(), y = in.ni();
            long w = in.ni();
            adj[x].add(new Pair(y, w));
            adj[y].add(new Pair(x, w));
        }
        out.println(prim(1));
    }

    private long prim(int x) {
        long result = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(x, 0));
        while (!queue.isEmpty()) {
            Pair edge = queue.poll();
            x = edge.to;
            if (marked[x]) continue;

            marked[x] = true;
            result += edge.weight;
            for (int i = 0; i < adj[x].size(); i++) {
                Pair next = adj[x].get(i);
                if (!marked[next.to]) {
                    queue.add(next);
                }
            }
        }
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
        try (MinimumSpanningTree instance = new MinimumSpanningTree()) {
            instance.solve();
        }
    }
}
