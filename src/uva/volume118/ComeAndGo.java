package uva.volume118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ComeAndGo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, m;
        while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
            reset(n);
            for (int i = 0; i < m; i++) {
                int u = in.ni() - 1, v = in.ni() - 1, type = in.ni();
                graph.get(u).add(v);
                reverse.get(v).add(u);
                if (type == 2) {
                    graph.get(v).add(u);
                    reverse.get(u).add(v);
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs1(i);
                }
            }
            int components = 0;
            for (int i = n - 1; i >= 0; i--) {
                int node = order.get(i);
                if (visited[node]) {
                    dfs2(node);
                    components++;
                }
            }
            out.println(components == 1 ? 1 : 0);
        }
    }

    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private boolean[] visited;

    private void reset(int n) {
        order = new ArrayList<>();
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        visited = new boolean[n];
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

    private void dfs2(int node) {
        visited[node] = false;
        for (int next : reverse.get(node)) {
            if (visited[next]) {
                dfs2(next);
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
        try (ComeAndGo instance = new ComeAndGo()) {
            instance.solve();
        }
    }
}
