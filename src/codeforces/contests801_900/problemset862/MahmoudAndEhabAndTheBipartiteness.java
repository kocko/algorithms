package codeforces.contests801_900.problemset862;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class MahmoudAndEhabAndTheBipartiteness implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Edge {
        private int u, v;

        private Edge(int u, int v) {
            this.u = Math.min(u, v);
            this.v = Math.max(u, v);
        }
    }
    
    private List<List<Integer>> graph = new ArrayList<>();
    
    public void solve() {
        int n = in.ni();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        color = new long[n + 1];
        visited = new boolean[n + 1];
        dfs(1, 1L);
        int zeroes = 0, ones = 0;
        long result = 0L;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) zeroes++;
            else ones++;
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) result += ones;
            else result += zeroes;
            result -= graph.get(i).size();
        }
        out.println(result >> 1L);
    }

    private long[] color;
    private boolean[] visited;
    
    private void dfs(int root, long c) {
        visited[root] = true;
        color[root] = c;
        List<Integer> neighbours = graph.get(root);
        for (int each : neighbours) {
            if (!visited[each]) {
                dfs(each, c ^ 1L); 
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
        try (MahmoudAndEhabAndTheBipartiteness instance = new MahmoudAndEhabAndTheBipartiteness()) {
            instance.solve();
        }
    }
}
