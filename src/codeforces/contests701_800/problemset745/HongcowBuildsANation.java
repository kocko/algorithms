package codeforces.contests701_800.problemset745;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HongcowBuildsANation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private long[] size;

        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                root[i] = i;
            }
            size = new long[n + 1];
            Arrays.fill(size, 1L);
        }

        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni(), k = in.ni();
        boolean[] gov = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            gov[in.ni()] = true;
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            dsu.union(u, v);
        }
        long nodes = n;
        long total = 0L;
        long max = 0L;
        for (int i = 1; i <= n; i++) {
            if (gov[i]) {
                int root = dsu.root(i);
                long size = dsu.size[root];
                nodes -= size;
                if (size > max) {
                    max = size;
                }
                long capacity = (size * (size - 1)) / 2;
                total += capacity;
            }
        }
        total += (nodes * (nodes - 1)) / 2;
        total += (nodes * max);
        out.println(total - m);
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
        try (HongcowBuildsANation instance = new HongcowBuildsANation()) {
            instance.solve();
        }
    }
}
