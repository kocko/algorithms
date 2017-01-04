package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Oreon implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class DisjointSet {
        private int[] root;
        private int[] size;

        public DisjointSet(int n) {
            root = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        public boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
        }

    }

    private class Edge implements Comparable<Edge> {
        private int u;
        private int v;
        private int w;

        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            int a = Integer.compare(this.w, o.w);
            int b = Integer.compare(this.u, o.u);
            int c = Integer.compare(this.v, o.v);
            if (a != 0) return a;
            return b != 0 ? b : c;
        }
    }
    
    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni();
            int[][] matrix = new int[n][n];
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.ni();
                    if (i < j && matrix[i][j] != 0) {
                        queue.offer(new Edge(i, j, matrix[i][j]));
                    }
                }
            }
            out.printf("Case %d:\n", testCase);
            DisjointSet dsu = new DisjointSet(n);
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (dsu.union(edge.u, edge.v)) {
                    char x = (char) (edge.u + 'A');
                    char y = (char) (edge.v + 'A');
                    out.printf("%s-%s %d\n", x, y, edge.w);
                }
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
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\r\n\f,");
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
        try (Oreon instance = new Oreon()) {
            instance.solve();
        }
    }
}
