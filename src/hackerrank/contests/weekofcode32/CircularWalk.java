package hackerrank.contests.weekofcode32;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CircularWalk implements Closeable {

    private InputReader in = new InputReader(System.in);
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
            return root[x] == x ? x : (root[x] = root(root[x]));
        }

        private boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                size[x] += size[y];
                root[y] = x;
                return true;
            }
            return false;
        }
    }

    public void solve() {
        int n = in.ni(), start = in.ni(), target = in.ni();
        int[] d = new int[n];
        final int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            d[i] = INF;
        }
        d[start] = 0;
        int[] r = new int[n];
        r[0] = in.ni();
        int g = in.ni(), seed = in.ni(), p = in.ni();
        for (int i = 1; i < n; i++) {
            r[i] = (r[i - 1] * g + seed) % p;
        }
        DisjointSet dsu = new DisjointSet(n);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        out: while (!queue.isEmpty()) {
            int top = queue.poll();
            int range = r[top];
            for (int k = 1; k <= range; k++) {
                int destination = (top + k) % n;
                if (dsu.union(top, destination)) {
                    d[destination] = d[top] + 1;
                    queue.add(destination);
                    if (destination == target) break out;
                }
                destination = top - k;
                if (destination < 0) destination = n + destination;
                if (dsu.union(top, destination)) {
                    d[destination] = d[top] + 1;
                    queue.add(destination);
                    if (destination == target) break out;
                }
            }
        }
        out.println(d[target] == INF ? -1 : d[target]);
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
        try (CircularWalk instance = new CircularWalk()) {
            instance.solve();
        }
    }
}
