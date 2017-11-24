package codeforces.contests401_500.problemset429;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class XorTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        init = new int[n + 1];
        goal = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.ni(), v = in.ni();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) init[i] = in.ni();
        for (int i = 1; i <= n; i++) goal[i] = in.ni();
        visited = new boolean[n + 1];
        dfs(1, 0, 0, 0);
        out.println(result.size());
        result.forEach(out::println);
    }

    private List<Integer> result = new ArrayList<>();
    private List<List<Integer>> tree = new ArrayList<>();
    private int[] init, goal;
    private boolean[] visited;
    
    private void dfs(int node, int level, int even, int odd) {
        visited[node] = true;
        init[node] ^= (level == 0) ? even : odd;
        int nextEven = even, nextOdd = odd;
        if (init[node] != goal[node]) {
            result.add(node);
            init[node] ^= 1;
            if (level == 0) nextEven ^= 1;
            else nextOdd ^= 1;
        }
        for (int next : tree.get(node)) {
            if (!visited[next]) {
                dfs(next, level ^ 1, nextEven, nextOdd);
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
        try (XorTree instance = new XorTree()) {
            instance.solve();
        }
    }
}
