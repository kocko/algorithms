package uva.volume002;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class RareOrder implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int[][] graph = new int[26][26];
    private boolean[] used = new boolean[26];

    public void solve() {
        char[] prev = in.next().toCharArray();
        int root = prev[0] - 'A';
        while (true) {
            char[] next = in.next().toCharArray();
            if (next[0] == '#') break;
            int limit = Math.min(prev.length, next.length);
            int j = 0;
            for (char c : next) {
                used[c - 'A'] = true;
            }
            while (j < limit) {
                if (prev[j] != next[j]) break;
                j++;
            }
            if (j < limit) {
                graph[prev[j] - 'A'][next[j] - 'A'] = 1;
            }
            prev = next;
        }
        dfs(root);
        for (int i = 0; i < 26; i++) {
            if (used[i] && !visited[i]) {
                dfs(i);
            }
        }
        for (int i = order.size() - 1; i >= 0; i--) {
            out.print((char) ('A' + order.get(i)));
        }
        out.println();
    }

    private boolean[] visited = new boolean[26];
    private List<Integer> order = new ArrayList<>();

    private void dfs(int x) {
        visited[x] = true;
        for (int u = 0; u < 26; u++) {
            if (graph[x][u] == 1 && !visited[u]) {
                dfs(u);
            }
        }
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

    public static void main(String[] args) throws IOException  {
        try (RareOrder instance = new RareOrder()) {
            instance.solve();
        }
    }
}
