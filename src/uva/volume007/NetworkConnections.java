package uva.volume007;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class NetworkConnections implements Closeable {

    private Scanner in = new Scanner(System.in);
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
        int t = parseInt(in.nextLine());
        in.nextLine();
        while (t-- > 0) {
            int n = parseInt(in.nextLine());
            DisjointSet dsu = new DisjointSet(n);
            String line;
            int positive = 0, negative = 0;
            while (in.hasNextLine() && !"".equals(line = in.nextLine())) {
                String[] split = line.split("\\s+");
                char operation = split[0].charAt(0);
                if (operation == 'q') {
                    int u = parseInt(split[1]), v = parseInt(split[2]);
                    if (dsu.root(u) == dsu.root(v)) positive++;
                    else negative++;
                } else {
                    dsu.join(parseInt(split[1]), parseInt(split[2]));
                }
            }
            out.println(positive + "," + negative);
            if (t > 0) out.println();
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (NetworkConnections instance = new NetworkConnections()) {
            instance.solve();
        }
    }
}
