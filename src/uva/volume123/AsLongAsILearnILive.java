package uva.volume123;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

public class AsLongAsILearnILive implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.ni(), m = in.ni();

            value = new int[n];
            graph = new ArrayList<>();
            last = sum = 0;
            for (int i = 0; i < n; i++) {
                value[i] = in.ni();
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = in.ni(), v = in.ni();
                graph.get(u).add(v);
            }
            for (int i = 0; i < n; i++) {
                graph.get(i).sort(comparingInt((x -> -value[x])));
            }
            dfs(0);

            out.printf("Case %d: %d %d\n", testCase, sum, last);
        }
    }

    private int sum = 0, last = 0;
    private int[] value;
    private List<List<Integer>> graph;

    private void dfs(int node) {
        sum += value[node];
        if (graph.get(node).size() == 0) {
            last = node;
        } else {
            dfs(graph.get(node).get(0));
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
        try (AsLongAsILearnILive instance = new AsLongAsILearnILive()) {
            instance.solve();
        }
    }
}
