package codeforces.contests600_699.problemset616;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheLabyrinth implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    static class DisjointSet {
        int[] root;
        int[] rank;

        public DisjointSet(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        void union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (rank[y] < rank[x]) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }
                rank[x] += rank[y];
                root[y] = x;
            }
        }
        
    }

    public void solve() {
        int n = in.ni();
        int m = in.ni();
        char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = in.next().toCharArray();
        }

        DisjointSet union = new DisjointSet(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.') {
                    if (i + 1 < n && g[i + 1][j] == '.')
                        union.union(i * m + j, i * m + j + m);
                    if (j + 1 < m && g[i][j + 1] == '.')
                        union.union(i * m + j, i * m + j + 1);
                }
            }
        }

        final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.')
                    continue;
                int[] roots = new int[4];
                int curRoot = 0;
                int total = 0;
                out: for (int[] d : dir) {
                    int x = i + d[0], y = j + d[1];
                    if (x < n && x >= 0 && y < m && y >= 0 && g[x][y] == '.') {
                        int root = union.root(x * m + y);
                        for (int u = 0; u < curRoot; u++) {
                            if (root == roots[u])
                                continue out;
                        }
                        roots[curRoot++] = root;
                        total += union.rank[root];
                    }
                }
                g[i][j] = (char) ('0' + (1 + total) % 10);
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(g[i]);
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
        try (TheLabyrinth instance = new TheLabyrinth()) {
            instance.solve();
        }
    }
}
