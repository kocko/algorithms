package codeforces.contests401_500.problemset437;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TheChildAndZoo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private long[] size;
        private long score;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            size = new long[n + 1];
            Arrays.fill(size, 1L);
        }
        
        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }
        
        private void union(int a, int b, long weight) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                score += weight * (size[x] * size[y]);
                size[x] += size[y];
                root[y] = x;
            }
        }
    }
    
    private class Edge implements Comparable<Edge> {
        private int u, v;
        private long w;
        
        private Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(o.w, this.w);
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        long[] w = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nl();
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            queue.offer(new Edge(u, v, Math.min(w[u], w[v])));
        }
        DisjointSet dsu = new DisjointSet(n);
        while (!queue.isEmpty()) {
            Edge top = queue.poll();
            dsu.union(top.u, top.v, top.w);
        }
        long total = dsu.score;
        long div = ((long) n) * (n - 1);
        out.println(((double) total * 2) / div);
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
        try (TheChildAndZoo instance = new TheChildAndZoo()) {
            instance.solve();
        }
    }
}
