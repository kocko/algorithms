package codeforces.contests301_400.problemset320;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PingPong implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Interval {
        int a;
        int b;

        private Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private boolean[][] graph = new boolean[101][101];
    private boolean[] visited;
    
    private void dfs(int u) {
        visited[u] = true;
        for (int i = 1; i < 101; i++) {
            if (graph[u][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public void solve() {
        int n = in.ni();
        Interval[] intervals = new Interval[101];
        int idx = 1;
        for (int c = 1; c <= n; c++) {
            int type = in.ni();
            int u = in.ni(), v = in.ni();
            if (type == 1) {
                Interval interval = new Interval(u, v);
                intervals[idx] = interval;
                for (int i = 1; i <= idx; i++) {
                    if (reachable(intervals[i], interval)) {
                        graph[i][idx] = true;
                    }
                    if (reachable(interval, intervals[i])) {
                        graph[idx][i] = true;
                    }
                }
                idx++;
            } else {
                visited = new boolean[101];
                dfs(u);
                out.println(visited[v] ? "YES" : "NO");
            }
        }
    }

    private boolean reachable(Interval m, Interval n) {
        return (m.a > n.a && m.a < n.b) || (m.b > n.a && m.b < n.b);
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
        try (PingPong instance = new PingPong()) {
            instance.solve();
        }
    }
}
