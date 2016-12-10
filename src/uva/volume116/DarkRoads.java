package uva.volume116;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DarkRoads implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    static class DisjointSet {
        private int[] root;
        private int[] size;

        public DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
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
        int x;
        int y;
        int w;

        private Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public void solve() {
        while (true) {
            int n = in.ni(), m = in.ni();
            if (n == 0 && m == 0) break;
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            int total = 0;
            for (int i = 0; i < m; i++) {
                int x = in.ni(), y = in.ni(), w = in.ni();
                total += w;
                queue.add(new Edge(x, y, w));
            }
            DisjointSet dsu = new DisjointSet(n);
            for (int i = 0; i < m; i++) {
                Edge next = queue.poll();
                if (dsu.union(next.x, next.y)) {
                    total -= next.w;
                }
            }
            out.println(total);
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
        try (DarkRoads instance = new DarkRoads()) {
            instance.solve();
        }
    }
}
