package codeforces.contests801_900.problemset842;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IlyaAndTheTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        value = new int[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) value[i] = in.ni();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0);
        dfs(1, -1, tree, 0);
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int[] value, result;
    private List<List<Integer>> graph = new ArrayList<>();

    private void dfs(int node, int parent, TreeSet<Integer> gcd, int g) {
        TreeSet<Integer> nextGcd = new TreeSet<>();
        for (int gg : gcd) {
            nextGcd.add(gcd(gg, value[node]));
        }
        result[node] = Math.max(nextGcd.last(), g);
        nextGcd.add(g);
        g = gcd(value[node], g);
        List<Integer> neighbours = graph.get(node);
        for (Integer next : neighbours) {
            if (next != parent) {
                dfs(next, node, nextGcd, g);
            }
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
        try (IlyaAndTheTree instance = new IlyaAndTheTree()) {
            instance.solve();
        }
    }
}
