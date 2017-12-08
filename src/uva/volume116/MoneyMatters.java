package uva.volume116;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MoneyMatters implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;
        private int[] debt;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            debt = new int[n];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        private void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = (x ^ y) ^ (x = y);
                root[y] = x;
                size[x] += size[y];
                debt[x] += debt[y];
            }
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            DisjointSet dsu = new DisjointSet(n);
            for (int i = 0; i < n; i++) {
                dsu.debt[i] = in.ni();
            }
            for (int i = 0; i < m; i++) {
                dsu.join(in.ni(), in.ni());
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (dsu.root(i) == i) {
                    ok &= dsu.debt[i] == 0;
                }
            }
            out.println(ok ? "POSSIBLE" : "IMPOSSIBLE");
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
        try (MoneyMatters instance = new MoneyMatters()) {
            instance.solve();
        }
    }
}
