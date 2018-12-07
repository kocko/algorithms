package codeforces.contests401_500.problemset489;

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

public class UnbearableControversyOfBeing implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        List<List<Integer>> graph = new ArrayList<>();
        ArrayDeque<Edge> edges = new ArrayDeque<>();
        int n = in.ni(), m = in.ni();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            graph.get(u).add(v);
            edges.add(new Edge(u, v));
        }
        long[][] cnt = new long[n][n];
        while (!edges.isEmpty()) {
            Edge top = edges.pollFirst();
            int u = top.from;
            for (int v : graph.get(top.to)) {
                if (v != u) {
                    cnt[u][v]++;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[i][j] != 0) {
                    result += comb(cnt[i][j]);
                }
            }
        }
        out.println(result);
    }

    private class Edge {
        private int from, to;

        private Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    private long comb(long cnt) {
        return (cnt * (cnt - 1)) / 2;
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
        try (UnbearableControversyOfBeing instance = new UnbearableControversyOfBeing()) {
            instance.solve();
        }
    }
}
