package codeforces.contests601_700.problemset615;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class LongtailHedgehog implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<List<Integer>> graph = new ArrayList<>();
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dp[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        long ans = 0L;
        for (int v = 1; v <= n; v++) {
            for (int u : graph.get(v)) {
                if (u < v) {
                    dp[v] = max(dp[v], dp[u] + 1);
                }
            }
            ans = Math.max(ans, dp[v] * graph.get(v).size());
        }
        out.println(ans);
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
        try (LongtailHedgehog instance = new LongtailHedgehog()) {
            instance.solve();
        }
    }
}
