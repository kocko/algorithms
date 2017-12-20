package codeforces.contests901_1000.problemset902;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ColoringATree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        c = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            graph.get(in.ni()).add(i);
        }
        for (int i = 1; i <= n; i++) {
            c[i] = in.ni();
        }
        dfs(1, 0);
        out.println(result);
    }
    
    private List<List<Integer>> graph = new ArrayList<>();
    private int[] c;
    private int result;
    
    private void dfs(int node, int parentColor) {
        if (parentColor != c[node]) {
            result++;
        }
        for (Integer next : graph.get(node)) {
            dfs(next, c[node]);
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
        try (ColoringATree instance = new ColoringATree()) {
            instance.solve();
        }
    }
}
