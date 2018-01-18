package codeforces.contests601_700.problemset601;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class TheTwoRoutes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        boolean[][] railway = new boolean[n][n], road = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                road[i][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            railway[u][v] = railway[v][u] = true;
            road[u][v] = road[v][u] = false;
        }
        boolean[][] graph = railway;
        if (railway[0][n - 1]) {
            graph = road;
        }
        int[] dist = new int[n];
        dist[0] = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            for (int i = 1; i < n; i++) {
                if (graph[node][i] && dist[i] == 0) {
                    dist[i] = dist[node] + 1;
                    queue.addLast(i);
                }
            }
        }
        int result = dist[n - 1] == 0 ? -1 : dist[n - 1];
        out.println(result);
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
        try (TheTwoRoutes instance = new TheTwoRoutes()) {
            instance.solve();
        }
    }
}
