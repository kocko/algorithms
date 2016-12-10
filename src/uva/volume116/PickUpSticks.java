package uva.volume116;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PickUpSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        while (true) {
            int n = in.ni(), m = in.ni();
            if (n == 0 && m == 0) break;
            adj = new ArrayList<>();
            order = new ArrayList<>();
            cycle = false;
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            int[] degree = new int[n + 1];
            for (int i = 1; i <= m; i++) {
                int a = in.ni(), b = in.ni();
                adj.get(a).add(b);
                degree[b]++;
            }
            visited = new boolean[n + 1];
            stack = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            if (!cycle) {
                for (int i = order.size() - 1; i >= 0; i--) {
                    out.println(order.get(i));
                }
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }

    private List<List<Integer>> adj;
    private List<Integer> order;
    private boolean[] visited;
    private boolean[] stack;
    private boolean cycle;

    private void dfs(int x) {
        visited[x] = stack[x] = true;
        List<Integer> next = adj.get(x);
        for (int u : next) {
            if (stack[u]) {
                cycle = true;
                return;
            } else if (!visited[u]) {
                dfs(u);
            }
        }
        stack[x] = false;
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

    public static void main(String[] args) {
        new PickUpSticks().solve();
    }
}
