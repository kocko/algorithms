package codeforces.contests1001_1100.problemset1013;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChemicalTable implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root, size;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = x ^ y ^ (x = y);
                size[x] += size[y];
                root[y] = x;
            }
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni(), q = in.ni();
        int max = n + m + 1;
        DisjointSet dsu = new DisjointSet(max);
        while (q-- > 0) {
            int u = in.ni(), v = in.ni();
            dsu.join(u, v + n);
        }
        int components = 0;
        for (int i = 1; i < max; i++) {
            if (dsu.root(i) == i) components++;
        }
        out.println(components - 1);
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
        try (ChemicalTable instance = new ChemicalTable()) {
            instance.solve();
        }
    }
}
