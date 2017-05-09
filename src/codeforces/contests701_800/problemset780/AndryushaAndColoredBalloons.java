package codeforces.contests701_800.problemset780;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AndryushaAndColoredBalloons implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        adjacent = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacent.add(new ArrayList<>());
        }
        int[] degree = new int[n + 1];
        int maxDegree = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
            degree[u]++;
            if (degree[u] > maxDegree) {
                maxDegree = degree[u];
            }
            degree[v]++;
            if (degree[v] > maxDegree) {
                maxDegree = degree[v];
            }
        }
        visited = new boolean[n + 1];
        result = new int[n + 1];
        dfs(1, 1, -1);
        out.println(maxDegree + 1);
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private List<List<Integer>> adjacent = new ArrayList<>();
    private boolean[] visited;
    private int[] result;

    private void dfs(int u, int color, int skip) {
        visited[u] = true;
        result[u] = color;
        int next = 1;
        while (next == color || next == skip) next++;
        for (Integer neighbour : adjacent.get(u)) {
            if (!visited[neighbour]) {
                dfs(neighbour, next, color);
                next++;
                while (next == color || next == skip) next++;
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
        try (AndryushaAndColoredBalloons instance = new AndryushaAndColoredBalloons()) {
            instance.solve();
        }
    }
}
