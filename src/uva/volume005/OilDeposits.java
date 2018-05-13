package uva.volume005;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OilDeposits implements Closeable {

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
                if (size[x] < size[y]) {
                    y = x ^ y ^ (x = y);
                }
                size[x] += size[y];
                root[y] = x;
            }
        }
    }

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            int m = in.ni();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = in.next().toCharArray();
            }
            DisjointSet dsu = new DisjointSet(n * m);
            int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '@') {
                        int x = m * i + j + 1;
                        for (int[] d : dir) {
                            int i_ = i + d[0];
                            int j_ = j + d[1];
                            if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < m && grid[i_][j_] == '@') {
                                int y = m * i_ + j_ + 1;
                                dsu.join(x, y);
                            }
                        }
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '@') {
                        int value = i * m + j + 1;
                        if (dsu.root(value) == value) {
                           result++;
                        }
                    }
                }
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
        try (OilDeposits instance = new OilDeposits()) {
            instance.solve();
        }
    }
}
