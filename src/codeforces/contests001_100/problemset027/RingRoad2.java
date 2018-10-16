package codeforces.contests001_100.problemset027;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RingRoad2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<int[]> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = in.ni(), b = in.ni();
            roads.add(new int[]{Math.min(a, b), Math.max(a, b)});
        }
        init(2 * m);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (intersect(roads.get(i), roads.get(j))) {
                    imply(not(2 * i), 2 * j);
                    imply(not(2 * j), 2 * i);
                    imply(2 * i, not(2 * j));
                    imply(2 * j, not(2 * i));
                }
            }
        }
        scc();
        boolean possible = true;
        boolean[] result = new boolean[m];
        for (int i = 0; i < component.length; i += 2) {
            possible &= component[i] != component[i + 1];
            result[i / 2] = component[i] > component[i + 1];
        }
        if (possible) {
            for (boolean value : result) {
                out.print(value ? "i" : "o");
            }
        } else {
            out.println("Impossible");
        }
    }

    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private int[] component;
    private boolean[] visited;

    private void init(int size) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        component = new int[size];
        visited = new boolean[size];
    }

    private void imply(int u, int v) {
        graph.get(u).add(v);
        reverse.get(v).add(u);
    }

    private int not(int value) {
        return value ^ 1;
    }

    private boolean intersect(int[] a, int[] b) {
        if (a[0] < b[0]) {
            return a[1] > b[0] && a[1] < b[1];
        } else {
            return a[0] != b[0] && a[0] < b[1] && a[1] > b[1];
        }
    }

    private void scc() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        int idx = 0;
        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);
            if (visited[node]) {
                dfs2(node, idx++);
            }
        }
    }

    private void dfs1(int u) {
        visited[u] = true;
        for (int v : graph.get(u)) if (!visited[v]) dfs1(v);
        order.add(u);
    }

    private void dfs2(int u, int cmp) {
        visited[u] = false;
        component[u] = cmp;
        for (int v : reverse.get(u)) if (visited[v]) dfs2(v, cmp);
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
        try (RingRoad2 instance = new RingRoad2()) {
            instance.solve();
        }
    }
}
