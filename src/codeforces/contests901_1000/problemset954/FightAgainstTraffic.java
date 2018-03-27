package codeforces.contests901_1000.problemset954;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FightAgainstTraffic implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni(), s = in.ni() - 1, t = in.ni() - 1;
        graph = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            graph[u][v] = graph[v][u] = true;
        }
        int[] ds = bfs(s);
        int[] dt = bfs(t);
        int distance = ds[t], result = 0;
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (!graph[u][v]) {
                    int min = min(ds[u] + dt[v], ds[v] + dt[u]) + 1;
                    if (min >= distance) {
                        result++;
                    }
                }
            }
        }    
        out.println(result);
    }
    
    private boolean[][] graph;
    
    private int[] bfs(int start) {
        int n = graph.length;
        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        visited[start] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] && !visited[v]) {
                    visited[v] = true;
                    queue.addLast(v);
                    result[v] = result[u] + 1;
                }
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
        try (FightAgainstTraffic instance = new FightAgainstTraffic()) {
            instance.solve();
        }
    }
}
