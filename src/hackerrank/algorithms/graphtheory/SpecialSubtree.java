package hackerrank.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecialSubtree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;
        
        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    private class DisjointSet {
        int[] root;
        int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                root[i] = i;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        private int root(int x) {
            return (root[x] == x) ? x : (root[x] = root(root[x]));
        }
        
        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                int sizeX = size[x], sizeY = size[y];
                if (sizeX < sizeY) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += sizeY;
            }
        }
    }
    
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        
        for (int i = 0; i < m; i++) {
            queue.add(new Edge(in.ni(), in.ni(), in.ni()));
        }
        int s = in.ni();
        int result = 0;
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 1; i <= n - 1; i++) {
            while (true) {
                Edge top = queue.peek();
                if (dsu.root(top.u) == dsu.root(top.v)) {
                    queue.poll();
                } else break;
            }
            Edge top = queue.poll();
            dsu.union(top.u, top.v);
            result += top.weight;
        }
        out.println(result);
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
        try (SpecialSubtree instance = new SpecialSubtree()) {
            instance.solve();
        }
    }
}
