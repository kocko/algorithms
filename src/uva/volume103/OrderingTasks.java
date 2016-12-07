package uva.volume103;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrderingTasks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (true) {
            int n = in.ni(), m = in.ni();
            if (n == 0 && m == 0) break;
            if (n == 1 && m == 1) {
                out.println(1);
            } else {
                go(n, m);
            }
            reset();
        }
    }

    private int[][] graph;
    private boolean[] visited;
    private List<Integer> order = new ArrayList<>();

    private void reset() {
        graph = null;
        visited = null;
        order = new ArrayList<>();
    }

    private void go(int n, int m) {
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            graph[in.ni()][in.ni()] = 1;
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            boolean ok = true;
            for (int j = 1; j <= n; j++) {
                if (graph[j][i] == 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                root = i;
                break;
            }
        }
        dfs(root);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        for (int i = order.size() - 1; i >= 0; i--) {
            out.print(order.get(i) + " ");
        }
        out.println();
    }

    private void dfs(int x) {
        visited[x] = true;
        for (int i = 1; i <= graph.length - 1; i++) {
            if (!visited[i] && graph[x][i] == 1) {
                dfs(i);
            }
        }
        order.add(x);
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

    public static void main(String[] args) throws IOException  {
        try (OrderingTasks instance = new OrderingTasks()) {
            instance.solve();
        }
    }

}
