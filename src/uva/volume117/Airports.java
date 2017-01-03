package uva.volume117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Airports implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;

        public DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        public boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
        }

    }
    
    private class Edge implements Comparable<Edge> {
        private int u;
        private int v;
        private int w;
        
        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), m = in.ni(), a = in.ni();
            DisjointSet dsu = new DisjointSet(n);
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                Edge edge = new Edge(in.ni(), in.ni(), in.ni());
                queue.offer(edge);
            }
            long total = 0L;
            for (int i = 0; i < m; i++) {
                Edge next = queue.poll();
                if (dsu.root(next.u) != dsu.root(next.v)) {
                    if (next.w < a) {
                        dsu.union(next.u, next.v);
                        total += next.w;
                    }
                }
            }
            int components = 0;
            for (int i = 1; i <= n; i++) {
                if (dsu.root(i) == i) {
                    components++;
                }
            }
            out.printf("Case #%d: %d %d\n", testCase, components * a + total, components);
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
        try (Airports instance = new Airports()) {
            instance.solve();
        }
    }
}
