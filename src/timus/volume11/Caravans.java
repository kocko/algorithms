package timus.volume11;

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

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Caravans implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        input();
        bfs(start, startDist);
        bfs(robbers, robberDist);
        out.println(recurse(finish));
    }

    private void input() {
        graph = new ArrayList<>();
        int n = in.ni(), m = in.ni();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        start = in.ni() - 1;
        finish = in.ni() - 1;
        robbers = in.ni() - 1;

        startDist = new Integer[n];
        robberDist = new Integer[n];
        dp = new Integer[n];
    }

    private int start, finish, robbers;
    private List<List<Integer>> graph;
    private Integer[] startDist, robberDist, dp;

    private void bfs(int start, Integer[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        arr[start] = 0;
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v : graph.get(u)) {
                if (arr[v] == null) {
                    arr[v] = arr[u] + 1;
                    queue.offerLast(v);
                }
            }
        }
    }

    private Integer recurse(int u) {
        if (u == start) return robberDist[start];
        if (dp[u] != null) return dp[u];

        int prev = -1;
        for (int v : graph.get(u)) {
            if (startDist[v] + 1 == startDist[u]) {
                prev = max(prev, recurse(v));
            }
        }
        return dp[u] = prev != -1 ? min(prev, robberDist[u]) : robberDist[u];
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
        try (Caravans instance = new Caravans()) {
            instance.solve();
        }
    }
}
