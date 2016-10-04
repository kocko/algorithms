package codeforces.contests701_800.problemset723;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class LakesInBerland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n, int m) {
            root = new int[n * m];
            for (int i = 0; i < m * n; i++) {
                root[i] = i;
            }
            size = new int[n * m];
            Arrays.fill(size, 1);
        }

        int root(int x) {
            return x == root[x] ? root[x] : (root[x] = root(root[x]));
        }

        void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                int sizeX = size[x], sizeY = size[y];
                if (sizeX < sizeY) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += size[y];
            }
        }
    }

    private int n;
    private int m;
    
    public void solve() {
        this.n = in.ni();
        this.m = in.ni();
        int k = in.ni();
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }

        DisjointSet dsu = new DisjointSet(n, m);

        boolean oceanic[] = new boolean[n * m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    int root = dsu.root(m * i + j);
                    if (isOceanic(i, j)) {
                        oceanic[root] = true;
                    }
                    if (i + 1 < n && grid[i + 1][j] == '.') {
                        dsu.union(i * m + j, i * m + j + m);
                        if (isOceanic(i + 1, j)) {
                            oceanic[root] = true;
                        }
                    }
                    if (j + 1 < m && grid[i][j + 1] == '.') {
                        dsu.union(i * m + j, i * m + j + 1);
                        if (isOceanic(i, j + 1)) {
                            oceanic[root] = true;
                        }
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '.') {
                        dsu.union(i * m + j, i * m - m + j);
                        if (isOceanic(i - 1, j)) {
                            oceanic[root] = true;
                        }
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '.') {
                        dsu.union(i * m + j, i * m + j - 1);
                        if (isOceanic(i, j - 1)) {
                            oceanic[root] = true;
                        }
                    }
                }
            }
        }
        
        
        int lakes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dsu.root(i * m + j) == i * m + j) {
                    if (grid[i][j] == '.' && !oceanic[i * m + j]) {
                        lakes++;
                    }
                }
            }
        }
        if (lakes == k) {
            out.println(0);
        } else {
            int count = 0;
            while (lakes > k) {
                int minSize = 3000, minRoot = -1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (dsu.root(i * m + j) == i * m + j) {
                            if (grid[i][j] == '.' && !oceanic[i * m + j]) {
                                if (dsu.size[i * m + j] < minSize) {
                                    minRoot = i * m + j;
                                    minSize = dsu.size[i * m + j];
                                }
                            }
                        }
                    }
                }
                if (minRoot != -1) {
                    for (int i = 1; i < n - 1; i++) {
                        for (int j = 1; j < m - 1; j++) {
                            if (grid[i][j] == '.' && dsu.root(i * m + j) == minRoot) {
                                dsu.root[i * m + j] = i * m + j;
                                dsu.size[i * m + j] = 1;
                                dsu.size[minRoot]--;
                                grid[i][j] = '*';
                                count++;
                            }
                        }
                    }
                    lakes--;
                }
            }
            out.println(count);
        }
        print(grid);
    }
    
    private boolean isOceanic(int i, int j) {
        return i == 0 || i == n - 1 || j == 0 || j == m - 1;
    }
    
    private void print(char[][] grid) {
        for (char[] row : grid) {
            for (char c : row) {
                out.print(c);
            }
            out.println();
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
        try (LakesInBerland instance = new LakesInBerland()) {
            instance.solve();
        }
    }
}
