package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            adj = new ArrayList<>();
            int n = in.ni();
            for (int j = 0; j <= n; j++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                int count = in.ni();
                for (int j = 0; j < count; j++) {
                    adj.get(i).add(in.ni());
                }
            }
            depth = new int[n + 1];
            visited = new boolean[n + 1];
            pa = new int[n + 1][12];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(pa[i], -1);
            }

            dfs(1, -1, 0);
            for (int i = 1; i <= 11; i++) {
                for (int j = 1; j <= n; j++) {
                    if (pa[j][i - 1] != -1) {
                        pa[j][i] = pa[pa[j][i - 1]][i - 1];
                    }
                }
            }
            out.printf("Case %d:\n", testCase);
            int q = in.ni();
            while (q-- > 0) {
                out.println(lca(in.ni(), in.ni()));
            }
        }
    }

    private List<List<Integer>> adj;
    private int[][] pa;
    private int[] depth;
    private boolean[] visited;

    private void dfs(int node, int parent, int d) {
        visited[node] = true;
        pa[node][0] = parent;
        depth[node] = d;
        
        List<Integer> next = adj.get(node);
        for (int v : next) {
            if (!visited[v]) {
                dfs(v, node, d + 1);
            }
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        for (int i = 11; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = pa[u][i];
            }
        }
        if (u == v) return u;
        for (int i = 11; i >= 0; i--) {
            if (pa[u][i] != -1 && pa[u][i] != pa[v][i]) {
                u = pa[u][i];
                v = pa[v][i];
            }
        }
        return pa[u][0];
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
        try (Main instance = new Main()) {
            instance.solve();
        }
    }
}
