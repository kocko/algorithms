package hackerearth.graphs;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class MonkAndTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            go();
        }
    }

    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        public int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        public boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                root[y] = x;
                size[x] += y;
                return true;
            }
            return false;
        }
    }
    
    private class Edge implements Comparable<Edge> {
        private int u, w;

        private Edge(int u, int w) {
            this.u = u;
            this.w = w;
        }
        
        public int getWeight() {
            return abs(u - w);
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.getWeight(), getWeight());
        }
    }

    private void go() {
        int n = in.ni(), m = in.ni();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        long total = 0;
        for (int i = 0; i < m; i++) {
            int u = in.ni(), w = in.ni();
            queue.offer(new Edge(u, w));
            total += abs(u - w);
        }
        DisjointSet dsu = new DisjointSet(n);
        long mstWeight = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (dsu.union(edge.u, edge.w)) {
                mstWeight += edge.getWeight();
            }
        }
        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (dsu.root(i) == i) components++;
        }
        out.println(total - mstWeight + components - 1);
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
        try (MonkAndTree instance = new MonkAndTree()) {
            instance.solve();
        }
    }
}
