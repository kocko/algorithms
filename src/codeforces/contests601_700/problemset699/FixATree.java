package codeforces.contests601_700.problemset699;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FixATree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = in.ni() - 1;
        }
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                dfs(i);
            }
        }
        int target = -1;
        for (int root : roots) {
            if (parent[root] == root) {
                target = root;
                break;
            }
        }
        int changes = 0;
        if (target == -1) {
            target = roots.get(0);
        }
        for (int root : roots) {
            if (parent[root] != target) {
                parent[root] = target;
                changes++;
            }
        }
        out.println(changes);
        for (int p : parent) {
            out.print(p + 1);
            out.print(' ');
        }
    }

    private int[] parent, color;
    private List<Integer> roots = new ArrayList<>();

    private void dfs(int u) {
        color[u] = 1;
        if (color[parent[u]] == 0) {
            dfs(parent[u]);
        } else if (color[parent[u]] == 1) {
            roots.add(u);
        }
        color[u] = 2;
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
        try (FixATree instance = new FixATree()) {
            instance.solve();
        }
    }
}
