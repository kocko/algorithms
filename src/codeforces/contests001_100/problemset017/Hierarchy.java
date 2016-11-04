package codeforces.contests001_100.problemset017;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hierarchy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private int weight;
        
        private Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
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
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }
        
        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
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
                size[x] += size[y];
            }
        }
    }

    public void solve() {
        int n = in.ni();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = in.ni();
        }
        int m = in.ni();
        boolean[] employee = new boolean[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        for (int i = 0; i < m; i++) {
            int from = in.ni();
            int to = in.ni();
            int weight = in.ni();
            employee[to] = true;
            queue.add(new Edge(from, to, weight));
        }
        int bosses = 0;
        for (int i = 1; i <= n; i++) {
            if (!employee[i]) bosses++;
        }
        if (bosses > 1) {
            out.println(-1);
            return;
        }
        int total = 0;
        DisjointSet dsu = new DisjointSet(n);
        boolean[] hasSupervisor = new boolean[n + 1];
        for (int i = 1; i <= n - 1; i++) {
            if (queue.isEmpty()) {
                out.println(-1);
                return;
            }
            Edge next = queue.poll();
            while ((dsu.root(next.from) == dsu.root(next.to)) || hasSupervisor[next.to]) {
                if (queue.isEmpty()) {
                    out.println(-1);
                    return;
                }
                next = queue.poll();
            }
            dsu.union(next.from, next.to);
            hasSupervisor[next.to] = true;
            total += next.weight;
        }
        out.println(total);
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
        try (Hierarchy instance = new Hierarchy()) {
            instance.solve();
        }
    }
}
