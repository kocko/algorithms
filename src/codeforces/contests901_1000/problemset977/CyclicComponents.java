package codeforces.contests901_1000.problemset977;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class CyclicComponents implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        graph = new ArrayList<>();
        degree = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            degree[u]++;
            degree[v]++;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && degree[i] == 2) {
                if (dfs(i)) result++;
            }
        }
        out.println(result);
    }
    
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int[] degree;
    
    private boolean dfs(int node) {
        visited[node] = true;
        boolean result = degree[node] == 2;
        for (Integer next : graph.get(node)) {
            if (!visited[next]) {
                result &= dfs(next);
            }
        }
        return result;
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
        try (CyclicComponents instance = new CyclicComponents()) {
            instance.solve();
        }
    }
}
