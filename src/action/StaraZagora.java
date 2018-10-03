package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StaraZagora implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni(), q = in.ni(), nodes = (x + y) << 1;
        init(nodes);
        while (q-- > 0) {
            int x1 = (in.ni() - 1) << 1, y1 = (in.ni() - 1) << 1, x2 = (in.ni() - 1) << 1, y2 = (in.ni() - 1) << 1;
            y1 += 2 * x;
            y2 += 2 * x;
            if (y1 > y2) {
                x1 = not(x1);
                x2 = not(x2);
            }
            if (x1 > x2) {
                y1 = not(y1);
                y2 = not(y2);
            }
            if (x1 == x2) {
                imply(not(x1), x2);
            } else if (y1 == y2) {
                imply(not(y1), y2);
            } else {
                //(x1 and y2) or (x2 or y1)
                //(x1 or x2) and (x1 or y1) and (x2 or y2) and (y1 or y2) 
                imply(not(x1), x2);
                imply(not(x2), x1);

                imply(not(x1), y1);
                imply(not(y1), x1);

                imply(not(y2), x2);
                imply(not(x2), y2);

                imply(not(y1), y2);
                imply(not(y2), y1);
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        int idx = 0;
        for (int i = nodes - 1; i >= 0; i--) {
            int node = order.get(i);
            if (visited[node]) {
                dfs2(node, idx++);
            }
        }

        boolean ok = true;
        for (int i = 0; i < nodes; i += 2) {
            ok &= (component[i] != component[i + 1]);
        }
        out.println(ok ? "Yes" : "No");
    }

    private boolean[] visited;
    private int[] component;
    private List<List<Integer>> graph, reverse;
    private List<Integer> order;

    private void init(int nodes) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        order = new ArrayList<>();
        component = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            component[i] = -1;
        }
        visited = new boolean[nodes];
    }

    private int not(int value) {
        return value ^ 1;
    }

    private void imply(int from, int to) {
        graph.get(from).add(to);
        reverse.get(to).add(from);
    }

    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        order.add(node);
    }

    private void dfs2(int node, int idx) {
        visited[node] = false;
        component[node] = idx;
        for (int next : reverse.get(node)) {
            if (visited[next]) {
                dfs2(next, idx);
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

    public static void main(String[] args) throws IOException {
        try (StaraZagora instance = new StaraZagora()) {
            instance.solve();
        }
    }
}
