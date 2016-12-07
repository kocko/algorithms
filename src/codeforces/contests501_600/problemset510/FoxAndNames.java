package codeforces.contests501_600.problemset510;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FoxAndNames implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    private int[][] graph = new int[26][26];

    public void solve() {
        int n = in.ni();
        char[] last = in.next().toCharArray();
        int root = last[0] - 'a';
        for (int i = 1; i < n; i++) {
            char[] current = in.next().toCharArray();
            int j = 0, limit = Math.min(current.length, last.length);
            while (j < limit) {
                if (current[j] != last[j]) break;
                j++;
            }
            if (j == limit && last.length > current.length) {
                out.println("Impossible");
                return;
            } else {
                if (j < limit) {
                    graph[last[j] - 'a'][current[j] - 'a'] = 1;
                }
            }
            last = current;
        }
        dfs(root);
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        if (cycle) {
            out.println("Impossible");
            return;
        }
        for (int i = 25; i >= 0; i--) {
            out.print((char)(order.get(i) + 'a'));
        }
        out.println();
    }

    private boolean[] visited = new boolean[26];
    private boolean[] stack = new boolean[26];
    private List<Integer> order = new ArrayList<>();
    private boolean cycle;

    private void dfs(int x) {
        visited[x] = stack[x] = true;
        for (int u = 0; u < 26; u++) {
            if (graph[x][u] == 1 && stack[u]) {
                cycle = true;
                return;
            }
            if (!visited[u] && graph[x][u] == 1) {
                dfs(u);
            }
        }
        stack[x] = false;
        order.add(x);
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
        try (FoxAndNames instance = new FoxAndNames()) {
            instance.solve();
        }
    }
}
