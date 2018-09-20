package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MonitoringTheAmazon implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, test = 0;
        while ((n = in.ni()) != 0) {
            test++;
            int[] x = new int[n], y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
                y[i] = in.ni();
            }
            graph = new ArrayList<>();
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int[] dist = {1000000, 1000000};
                int[] idx = {-1, -1};
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int distance = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                        if (distance < dist[0]) {
                            dist[1] = dist[0];
                            dist[0] = distance;
                            idx[1] = idx[0];
                            idx[0] = j;
                        } else if (distance == dist[0]) {
                            if (x[j] < x[idx[0]]) {
                                idx[1] = idx[0];
                                dist[1] = distance;
                                idx[0] = j;
                            } else if (x[j] == x[idx[0]]) {
                                if (y[j] < y[idx[0]]) {
                                    idx[1] = idx[0];
                                    idx[0] = j;
                                } else {
                                    idx[1] = j;
                                }
                                dist[1] = distance;
                            } else {
                                dist[1] = distance;
                                idx[1] = j;
                            }
                        } else if (distance < dist[1]) {
                            dist[1] = distance;
                            idx[1] = j;
                        } else if (distance == dist[1]) {
                            if (x[j] < x[idx[1]]) {
                                idx[1] = j;
                            } else if (x[j] == x[idx[1]]) {
                                if (y[j] < y[idx[1]]) {
                                    idx[1] = j;
                                }
                            }
                        }
                    }
                }
                graph.add(new ArrayList<>());
                for (int p : idx) if (p != -1) graph.get(i).add(p);
            }
            boolean ok = true;
            if (n > 1) {
                dfs(0);
                for (int i = 0; i < n; i++) {
                    ok &= visited[i];
                }
            }
            out.println(ok ? "All stations are reachable." : "There are stations that are unreachable.");
        }
    }

    private List<List<Integer>> graph;
    private boolean[] visited;

    private void dfs(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) if (!visited[next]) dfs(next);
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
        try (MonitoringTheAmazon instance = new MonitoringTheAmazon()) {
            instance.solve();
        }
    }
}
