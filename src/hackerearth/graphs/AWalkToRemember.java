package hackerearth.graphs;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class AWalkToRemember implements Closeable {

    private InputReader in;
    private PrintWriter out;

    public void solve() throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out, true);
        int n = in.ni(), m = in.ni();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            scc.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            reverse.get(v).add(u);
        }
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        visited = new boolean[n + 1];
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (!visited[top]) {
                dfs2(top, idx++);
            }
        }
        int[] result = new int[n + 1];
        for (int i = 0; i < idx; i++) {
            if (scc.get(i).size() > 1) {
                for (int v : scc.get(i)) {
                    result[v] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
        out.close();
    }

    private List<List<Integer>> graph = new ArrayList<>();
    private List<List<Integer>> reverse = new ArrayList<>();
    private List<List<Integer>> scc = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();
    private int idx = 0;
    private boolean[] visited;

    private void dfs1(int node) {
        visited[node] = true;
        List<Integer> neighbours = graph.get(node);
        for (Integer next : neighbours) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        stack.push(node);
    }

    private void dfs2(int node, int idx) {
        visited[node] = true;
        scc.get(idx).add(node);
        List<Integer> neighbours = reverse.get(node);
        for (Integer next : neighbours) {
            if (!visited[next]) {
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

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new AWalkToRemember().solve();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "1", 1 << 23).start();
    }
}