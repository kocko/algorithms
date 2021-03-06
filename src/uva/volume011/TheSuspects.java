package uva.volume011;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSuspects implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
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
                size[x] += size[y];
                root[y] = x;
            }
        }
    }
    
    public void solve() {
        int n, m;
        while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
            DisjointSet dsu = new DisjointSet(n);
            for (int i = 0; i < m; i++) {
                int k = in.ni(), first = -1;
                for (int j = 0; j < k; j++) {
                    if (j == 0) first = in.ni();
                    else dsu.join(in.ni(), first);
                }
            }
            out.println(dsu.size[dsu.root(0)]);
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
        try (TheSuspects instance = new TheSuspects()) {
            instance.solve();
        }
    }
}
