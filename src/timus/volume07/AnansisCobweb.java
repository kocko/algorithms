package timus.volume07;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnansisCobweb implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root, size;
        private int components;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
            components = n;
        }

        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    y = x ^ y ^ (x = y);
                }
                root[y] = x;
                size[x] += size[y];
                components--;
            }
        }
    }

    private class Edge {
        private int u, v;
        private boolean deleted;

        private Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        Edge[] edges = new Edge[m];
        for (int idx = 0; idx < m; idx++) {
            edges[idx] = new Edge(in.ni() - 1, in.ni() - 1);
        }
        int q = in.ni();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = in.ni() - 1;
            edges[queries[i]].deleted = true;
        }
        DisjointSet dsu = new DisjointSet(n);
        for (Edge edge : edges) {
            if (!edge.deleted) {
                dsu.union(edge.u, edge.v);
            }
        }
        int[] result = new int[q];
        for (int i = q - 1; i >= 0; i--) {
            result[i] = dsu.components;
            Edge edge = edges[queries[i]];
            dsu.union(edge.u, edge.v);
        }
        for (int c : result) {
            out.print(c);
            out.print(' ');
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
        try (AnansisCobweb instance = new AnansisCobweb()) {
            instance.solve();
        }
    }
}
