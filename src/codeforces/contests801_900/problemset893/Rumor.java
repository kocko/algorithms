package codeforces.contests801_900.problemset893;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Rumor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private long[] c;
        private int[] root;
        
        private DisjointSet(int n, long[] c) {
            this.c = c;
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
        }
        
        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (c[x] > c[y]) {
                    y = (x ^ y) ^ (x = y);
                }
                root[y] = x;
            }
        }
    }
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.nl();
        }
        DisjointSet dsu = new DisjointSet(n, c);
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            dsu.join(u, v);
        }
        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (dsu.root(i) == i) result += c[i];
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
        try (Rumor instance = new Rumor()) {
            instance.solve();
        }
    }
}
