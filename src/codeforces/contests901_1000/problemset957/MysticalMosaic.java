package codeforces.contests901_1000.problemset957;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MysticalMosaic implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;
        
        public DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        public int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        public void join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = x ^ y ^ (x = y);
                size[x] += size[y];
                root[y] = x;
            }
        }
    }

    public void solve() {
        int n = in.ni();
        m = in.ni();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areSame(i, j)) {
                    dsu.join(i, j);
                }
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (dsu.root(i) == i) {
                for (int j = 0; j < n; j++) {
                    boolean different = true;
                    if (dsu.root(j) != i) {
                        for (int k = 0; k < m; k++) {
                            different &= (grid[i][k] == '.' && grid[j][k] == '.') || (grid[i][k] != grid[j][k]);
                        }
                    }
                    ok &= different;
                }
            }
        }
        out.println(ok ? "Yes" : "No");
    }

    private int m;
    private char[][] grid;
    
    private boolean areSame(int x, int y) {
        boolean same = true;
        for (int i = 0; i < m; i++) {
            same &= grid[x][i] == grid[y][i];   
        }
        return same;
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
        try (MysticalMosaic instance = new MysticalMosaic()) {
            instance.solve();
        }
    }
}
