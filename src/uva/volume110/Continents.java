package uva.volume110;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Continents implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class DisjointSet {
        private int[] root;
        private int[] size;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        private int root(int x) {
            return (x == root[x]) ? x : (root[x] = (root(root[x])));
        }

        private void union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = (x ^ y) ^ (x = y);
                size[x] += size[y];
                root[y] = x;
            }

        }
    }

    public void solve() {
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = in.nextLine().toCharArray();
            }
            line = in.nextLine().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            char land = map[x][y];
            DisjointSet dsu = new DisjointSet(n * m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == land) {
                        if (i - 1 >= 0 && map[i - 1][j] == land) {
                            dsu.union(i * m + j, (i - 1) * m + j);
                        }
                        
                        if (i + 1 < n && map[i + 1][j] == land) {
                            dsu.union(i * m + j, (i + 1) * m + j);
                        }
                        
                        if (j - 1 >= 0 && map[i][j - 1] == land) {
                            dsu.union(i * m + j, i * m + j - 1);
                        } else if (j - 1 < 0 && map[i][m - 1] == land) {
                            dsu.union(i * m + j, i * m + m - 1);
                        }
                        
                        if (j + 1 < m && map[i][j + 1] == land) {
                            dsu.union(i * m + j, i * m + j + 1);
                        } else if (j + 1 == m && map[i][0] == land) {
                            dsu.union(i * m + j, i * m);
                        }
                    }
                }
            }
            int root = dsu.root(x * m + y);
            int max = 0;
            for (int i = 0; i < m * n; i++) {
                int q = i % m, p = (i - q) / m;
                if (dsu.root(i) == i && map[p][q] == land && i != root) {
                    max = Math.max(max, dsu.size[i]);
                }
            }
            out.println(max);
            in.nextLine();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (Continents instance = new Continents()) {
            instance.solve();
        }
    }
}
