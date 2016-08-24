package csadademy.problemset011;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectTheGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class DisjointSet {
        int[] root;
        int[] size;

        public DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        public void union(int a, int b) {
            int x = root(a), y = root(b);
            int sizeX = size[x], sizeY = size[y];
            if (sizeX < sizeY) {
                int t = x;
                x = y;
                y = t;
            }
            root[y] = x;
            size[x] += size[y];
        }

        boolean same(int x, int y) {
            return root(x) == root(y);
        }

    }

    class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        DisjointSet dsu = new DisjointSet(n);

        List<Edge> delete = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.ni(), y = in.ni();
            if (!dsu.same(x, y)) {
                dsu.union(x, y);
            } else {
                delete.add(new Edge(x, y));
            }
        }
        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dsu.root(i) == i) roots.add(i);
        }

        if (roots.size() - 1 > delete.size()) {
            out.println(-1);
        } else {
            out.println(roots.size() - 1);
            for (int i = 1; i < roots.size(); i++) {
                Edge e = delete.get(i - 1);
                out.println(e.x + " " + e.y + " " + roots.get(i) + " " + roots.get(i - 1));
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

    public static void main(String[] args) {
        new ConnectTheGraph().solve();
    }
}
