package codeforces.contests201_300.problemset216;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FormingTeams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        int m = in.ni();
        graph = new boolean[n + 1][n + 1];
        team = new int[n + 1];
        bench = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            team[i] = -1;
            bench[i] = false;
        }
        while (m-- > 0) {
            int u = in.ni(), v = in.ni();
            graph[u][v] = graph[v][u] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (team[i] == -1 && !bench[i]) {
                dfs(i, 1);
            }
        }
        
        int result = 0;
        for (boolean b : bench) {
            if (b) result++;
        }
        if ((n - result) % 2 == 1) result++;
        out.println(result);
    }

    private int n;
    private int[] team;
    private boolean[][] graph;
    private boolean[] bench;

    private void dfs(int node, int color) {
        team[node] = color;
        for (int next = 1; next <= n; next++) {
            if (graph[node][next]) {
                if (team[next] == -1) {
                    dfs(next, color ^ 1);
                } else if (!bench[next] && !bench[node] && team[next] == color) {
                    bench[next] = true;
                }
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
        try (FormingTeams instance = new FormingTeams()) {
            instance.solve();
        }
    }
}
