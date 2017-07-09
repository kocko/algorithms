package uva.volume004;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GraphConnectivity implements Closeable {

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
            return x == root[x] ? x : (root[x] = root(root[x]));
        }
        
        private void union(int a, int b) {
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
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.next().charAt(0) - 'A' + 1;
            in.nextLine();
            DisjointSet dsu = new DisjointSet(n);
            String line = in.nextLine();
            while (line.length() > 1) {
                dsu.union(line.charAt(0) - 'A', line.charAt(1) - 'A');
                if (in.hasNextLine()) {
                    line = in.nextLine();
                } else break;
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dsu.root(j) == j) cnt++;
            }
            out.println(cnt);
            if (t > 0) out.println();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (GraphConnectivity instance = new GraphConnectivity()) {
            instance.solve();
        }
    }
}
