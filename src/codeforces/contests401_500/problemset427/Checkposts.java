package codeforces.contests401_500.problemset427;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Checkposts implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.ni();
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            scc.add(new ArrayList<>());
        }
        int m = in.ni();
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
        long result = 0L, ways = 1L, mod = (long) 1e9 + 7;
        for (int i = 0; i < idx; i++) {
            List<Integer> component = scc.get(i);
            component.sort(Comparator.comparingInt(x -> c[x]));
            long count = 1L;
            for (int j = 1; j < component.size(); j++) {
                if (c[component.get(j)] == c[component.get(0)]) count++;
                else break;
            }
            ways = (ways * count) % mod;
            result += c[component.get(0)];
        }
        out.println(result + " " + ways);
    }
    
    private List<List<Integer>> graph = new ArrayList<>();
    private List<List<Integer>> reverse = new ArrayList<>();
    private List<List<Integer>> scc = new ArrayList<>();
    private int idx = 0;
    private Stack<Integer> stack = new Stack<>();
    private boolean[] visited;
    
    private void dfs1(int node) {
        visited[node] = true;
        List<Integer> next = graph.get(node);
        for (int i : next) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        stack.add(node);
    }

    private void dfs2(int node, int idx) {
        visited[node] = true;
        scc.get(idx).add(node);
        List<Integer> next = reverse.get(node);
        for (int i : next) {
            if (!visited[i]) {
                dfs2(i, idx);
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
        try (Checkposts instance = new Checkposts()) {
            instance.solve();
        }
    }
}
