package codeforces.contests1001_1100.problemset1006;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MilitaryProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), q = in.ni();
        order = new int[n];
        index = new int[n + 1];
        children = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new TreeSet<>());
        }
        for (int u = 2; u <= n; u++) {
            graph.get(in.ni()).add(u);
        }
        dfs(1);
        while (q-- > 0) {
            int u = in.ni(), k = in.ni();
            int pos = index[u];
            int ans = -1;
            if (children[u] >= k) {
                ans = order[pos + k - 1];
            }
            out.println(ans);
        }
    }

    private List<Set<Integer>> graph = new ArrayList<>();
    private int idx;
    private int[] order, index, children;

    private int dfs(int u) {
        order[idx] = u;
        index[u] = idx++;
        int subordinates = 1;
        for (int v : graph.get(u)) {
            subordinates += dfs(v);
        }
        return children[u] = subordinates;
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
        try (MilitaryProblem instance = new MilitaryProblem()) {
            instance.solve();
        }
    }
}
