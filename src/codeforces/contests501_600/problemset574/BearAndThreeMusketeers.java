package codeforces.contests501_600.problemset574;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndThreeMusketeers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] deg = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        int[][] edges = new int[m][2]; 
        for (int i = 0; i < m; i++) {
            int u = in.ni(), v = in.ni();
            graph[u][v] = graph[v][u] = 1;
            deg[u]++;
            deg[v]++;
            edges[i] = new int[]{Math.min(u, v), Math.max(u, v)};
        }
        final int INF = (int) 1e7;
        int result = INF;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (edges[i][1] == edges[j][0] && graph[edges[j][1]][edges[i][0]] == 1) {
                    int score = deg[edges[i][0]] + deg[edges[i][1]] + deg[edges[j][1]] - 6;
                    if (score < result) result = score;
                }
            }
        }
        out.println(result == INF ? -1 : result);
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
        try (BearAndThreeMusketeers instance = new BearAndThreeMusketeers()) {
            instance.solve();
        }
    }
}
