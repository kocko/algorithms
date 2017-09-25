package codeforces.contests101_200.problemset104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cthulhu implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root, size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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
                if (size[x] < size[y]) y = (x + y) - (x = y);
                root[y] = x;
                size[x] += size[y];
            }
        }
    }
    
    public void solve() {
        int n = in.ni(), m = in.ni();
        if (n != m) {
            out.println("NO");
        } else {
            DisjointSet dsu = new DisjointSet(n);
            for (int i = 0; i < m; i++) {
                dsu.join(in.ni(), in.ni());
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (dsu.root(i) == i) cnt++;
            }
            if (cnt == 1) {
                out.println("FHTAGN!");
            } else {
                out.println("NO");
            }
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
        try (Cthulhu instance = new Cthulhu()) {
            instance.solve();
        }
    }
}
