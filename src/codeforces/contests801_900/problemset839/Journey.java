package codeforces.contests801_900.problemset839;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Journey implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = in.ni() - 1, v = in.ni() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        out.println(dfs(0, -1));
    }

    private List<List<Integer>> graph = new ArrayList<>();

    private double dfs(int node, int parent) {
        double sum = 0d;
        int size = graph.get(node).size();
        for (Integer next : graph.get(node)) {
            if (next != parent) {
                sum += dfs(next, node) + 1.0;
            }
        }
        if (parent != -1) size--;
        return sum != 0 ? sum / size  : 0;
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
        try (Journey instance = new Journey()) {
            instance.solve();
        }
    }
}
