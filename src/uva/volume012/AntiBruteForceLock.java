package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.util.Comparator.comparingInt;

public class AntiBruteForceLock implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            go();
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

        private int root(int x) {
            return x == root[x] ? x : (root[x] = root(root[x]));
        }

        private boolean union(int a, int b) {
            int x = root(a), y = root(b);
            if (x != y) {
                if (size[x] < size[y]) y = x ^ y ^ (x = y);
                root[y] = x;
                size[x] += size[y];
                return true;
            }
            return false;
        }
    }

    private void go() {
        int n = in.ni();
        List<Node> nodes = new ArrayList<>();
        int start = 1000;
        for (int i = 0; i < n; i++) {
            String label = in.next();
            nodes.add(new Node(i, label));
            int weight = 0;
            for (int k = 0; k < 4; k++) {
                int a = nodes.get(i).value.charAt(k) - '0';
                int b = 0;
                int max = Math.max(a, b), min = Math.min(a, b);
                weight += min((max - min), (10 - max + min));
            }
            start = min(start, weight);
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>(comparingInt(Edge::getWeight));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = 0;
                for (int k = 0; k < 4; k++) {
                    int a = nodes.get(i).value.charAt(k) - '0';
                    int b = nodes.get(j).value.charAt(k) - '0';
                    int max = Math.max(a, b), min = Math.min(a, b);
                    weight += min((max - min), (10 - max + min));
                }
                queue.add(new Edge(i, j, weight));
            }
        }
        int cost = 0;
        DisjointSet dsu = new DisjointSet(n);
        while (!queue.isEmpty()) {
            Edge top = queue.poll();
            if (dsu.union(top.u, top.v)) {
                cost += top.weight;
            }
        }
        out.println(cost + start);
    }

    private class Node {
        private int idx;
        private String value;

        private Node(int idx, String value) {
            this.idx = idx;
            this.value = value;
        }
    }

    private class Edge {
        private int u, v, weight;

        private Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
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
        try (AntiBruteForceLock instance = new AntiBruteForceLock()) {
            instance.solve();
        }
    }
}
