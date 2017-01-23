package codeforces.contests501_600.problemset505;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MrKitayutasColorfulGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        private DisjointSet(int n) {
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            size = new int[n + 1];
            Arrays.fill(size, 1);
        }
        
        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }
        
        public void union(int a, int b) {
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
        int n = in.ni(), m = in.ni();
        DisjointSet[] dsu = new DisjointSet[101];
        for (int i = 0; i < 101; i++) {
            dsu[i] = new DisjointSet(n);
        }
        while (m-- > 0) {
            int u = in.ni(), v = in.ni(), c = in.ni();
            dsu[c].union(u, v);
        }
        int q = in.ni();
        while (q-- > 0) {
            int result = 0;
            int u = in.ni(), v = in.ni();
            for (int i = 1; i < 101; i++) {
                if (dsu[i].root(u) == dsu[i].root(v)) result++;
            }
            out.println(result);
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
        try (MrKitayutasColorfulGraph instance = new MrKitayutasColorfulGraph()) {
            instance.solve();
        }
    }
}
