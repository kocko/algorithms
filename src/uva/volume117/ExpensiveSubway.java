package uva.volume117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class ExpensiveSubway implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (true) {
            int n = in.ni(), m = in.ni();
            if (n == 0 && m == 0) break;
            String[] stations = new String[n];
            Map<String, Integer> inverse = new HashMap<>();

            for (int i = 0; i < n; i++) {
                stations[i] = in.next();
                inverse.put(stations[i], i);
            }

            PriorityQueue<Edge> queue = new PriorityQueue<>(comparingInt(e -> e.w));
            for (int i = 0; i < m; i++) {
                queue.offer(new Edge(inverse.get(in.next()), inverse.get(in.next()), in.ni()));
            }
            String home = in.next();

            int result = 0;
            DisjointSet dsu = new DisjointSet(n);
            int joined = 0;
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (dsu.join(edge.u, edge.v)) {
                    result += edge.w;
                    joined++;
                    if (joined == n - 1) break;
                }
            }
            out.println(joined == n - 1 ? result : "Impossible");
        }
    }

    private class Edge {
        private int u, v, w;

        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private class DisjointSet {
        private int[] root, size;

        private DisjointSet(int n) {
            root = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        public int root(int x) {
            return (x == root[x]) ? x : (root[x] = root(root[x]));
        }

        public boolean join(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = (x ^ y) ^ (x = y);
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
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
        try (ExpensiveSubway instance = new ExpensiveSubway()) {
            instance.solve();
        }
    }
}
